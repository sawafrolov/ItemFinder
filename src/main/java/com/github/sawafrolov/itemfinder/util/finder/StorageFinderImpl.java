package com.github.sawafrolov.itemfinder.util.finder;

import com.github.sawafrolov.itemfinder.dao.search.SearchDao;
import com.github.sawafrolov.itemfinder.models.entities.ItemEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageFinderImpl implements StorageFinder {

    @Autowired
    private SearchDao searchDao;

    @Override
    public ArrayList<Integer> findItems(int boxId, String color) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        List<ItemEntity> items = searchDao.searchItems(color);
        for (ItemEntity item: items) {
            if (searchDao.isInTargetBox(item, boxId)) {
                result.add(item.getId());
            }
        }
        return result;
    }
}