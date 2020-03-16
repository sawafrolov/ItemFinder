package com.github.sawafrolov.itemfinder.dao.search;

import com.github.sawafrolov.itemfinder.models.entities.ItemEntity;

import java.util.List;

public interface SearchDao {

    List<ItemEntity> searchItems(String color);

    boolean isInTargetBox(ItemEntity itemEntity, int boxId);
}