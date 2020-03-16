package com.github.sawafrolov.itemfinder.util.reader;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.sawafrolov.itemfinder.models.xml.Storage;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageReaderImpl implements StorageReader {

    @Autowired
    private XmlMapper xmlMapper;

    public Storage readStorage(String fileName) throws Exception {
        Storage storage = xmlMapper.readValue(new File(fileName), Storage.class);
        return storage;
    }
}