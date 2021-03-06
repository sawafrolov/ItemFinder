package com.github.sawafrolov.itemfinder.dao.insertion;

import com.github.sawafrolov.itemfinder.models.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InsertionDaoImpl implements InsertionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insertBox(BoxEntity box) {
        Session session = sessionFactory.getCurrentSession();
        session.save(box);
    }

    @Override
    @Transactional
    public void insertItem(ItemEntity item) {
        Session session = sessionFactory.getCurrentSession();
        session.save(item);
    }
}