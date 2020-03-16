package com.github.sawafrolov.itemfinder.dao.search;

import com.github.sawafrolov.itemfinder.models.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchDaoImpl implements SearchDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ItemEntity> searchItems(String color) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ItemEntity e where :c = e.color", ItemEntity.class);
        query.setParameter("c", color);
        List<ItemEntity> result = new ArrayList<ItemEntity>();
        List list = query.list();
        for (Object obj: list) {
            result.add((ItemEntity) obj);
        }
        return result;
    }

    @Override
    public boolean isInTargetBox(ItemEntity item, int boxId) {
        int containedIn = item.getContainedIn();
        if (containedIn == boxId) {
            return true;
        }
        if (containedIn == 0) {
            return false;
        }
        return isInTargetBox(containedIn, boxId);
    }

    private boolean isInTargetBox(int boxId, int targetBoxId) {
        Session session = sessionFactory.getCurrentSession();
        BoxEntity box = (BoxEntity) session.get(BoxEntity.class, boxId);
        int containedIn = box.getContainedIn();
        if (containedIn == targetBoxId) {
            return true;
        }
        if (containedIn == 0) {
            return false;
        }
        return isInTargetBox(containedIn, boxId);
    }
}