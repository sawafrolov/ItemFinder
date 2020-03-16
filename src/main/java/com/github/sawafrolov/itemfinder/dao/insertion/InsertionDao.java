package com.github.sawafrolov.itemfinder.dao.insertion;

import com.github.sawafrolov.itemfinder.models.entities.*;

public interface InsertionDao {

    void insertBox(BoxEntity box);

    void insertItem(ItemEntity item);
}