package com.github.sawafrolov.itemfinder.util.writer;

import com.github.sawafrolov.itemfinder.dao.insertion.InsertionDao;
import com.github.sawafrolov.itemfinder.models.entities.*;
import com.github.sawafrolov.itemfinder.models.xml.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageWriterImpl implements StorageWriter {

    @Autowired
    private InsertionDao insertionDao;

    private List<BoxEntity> boxes = new ArrayList<BoxEntity>();

    private List<ItemEntity> items = new ArrayList<ItemEntity>();

    @Override
    public void writeStorage(Storage storage) {
        boxes.add(createBox(0, 0));
        for (Item item: storage.getItems()) {
            items.add(createItem(item, 0));
        }
        for (Box box: storage.getBoxes()) {
            readBox(box, 0);
        }
        for (BoxEntity box: boxes) {
            insertionDao.insertBox(box);
        }
        for (ItemEntity item: items) {
            insertionDao.insertItem(item);
        }
    }

    private void readBox(Box box, int containedIn) {
        boxes.add(createBox(box.getId(), containedIn));
        for (Item item: box.getItems()) {
            items.add(createItem(item, box.getId()));
        }
        for (Box b: box.getBoxes()) {
            readBox(b, box.getId());
        }
    }

    private BoxEntity createBox(int boxId, int containedIn) {
        BoxEntity result = new BoxEntity();
        result.setId(boxId);
        result.setContainedIn(containedIn);
        return result;
    }

    private ItemEntity createItem(Item item, int containedIn) {
        ItemEntity result = new ItemEntity();
        result.setId(item.getId());
        result.setColor(item.getColor());
        result.setContainedIn(containedIn);
        return result;
    }
}