package com.github.sawafrolov.itemfinder.main;

import com.github.sawafrolov.itemfinder.models.xml.Storage;
import com.github.sawafrolov.itemfinder.util.reader.StorageReader;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.sawafrolov.itemfinder")
public class Main {

    @Autowired
    StorageReader reader;

    private static String fileName;

    @PostConstruct
    public void readStorage() {
        try {
            Storage storage = reader.readStorage(fileName);
            int id = storage.getBoxes().get(0).getId();
            System.out.println(id);
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