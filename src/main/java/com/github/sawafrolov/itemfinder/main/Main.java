package com.github.sawafrolov.itemfinder.main;

import com.github.sawafrolov.itemfinder.models.xml.Storage;
import com.github.sawafrolov.itemfinder.util.reader.StorageReader;
import com.github.sawafrolov.itemfinder.util.writer.StorageWriter;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.sawafrolov.itemfinder")
public class Main {

    @Autowired
    private StorageReader reader;

    @Autowired
    private StorageWriter writer;

    private static String fileName;

    @PostConstruct
    public void prepareDataBase() {
        try {
            Storage storage = reader.readStorage(fileName);
            int id = storage.getBoxes().get(0).getId();
            System.out.println(id);
            writer.writeStorage(storage);
        } catch (Exception exc) {
            exc.printStackTrace();
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        fileName = args[0];
        SpringApplication.run(Main.class, args);
    }
}