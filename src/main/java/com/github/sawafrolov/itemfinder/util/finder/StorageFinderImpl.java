package com.github.sawafrolov.itemfinder.util.finder;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class StorageFinderImpl implements StorageFinder {

    private ArrayList<Integer> list;

    @Override
    public ArrayList<Integer> findItems(int boxId, String color) {
        list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        return list;
    }
}