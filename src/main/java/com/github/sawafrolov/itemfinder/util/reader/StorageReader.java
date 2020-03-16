package com.github.sawafrolov.itemfinder.util.reader;

import com.github.sawafrolov.itemfinder.models.xml.Storage;

public interface StorageReader {

    Storage readStorage(String fileName) throws Exception;
}