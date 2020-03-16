package com.github.sawafrolov.itemfinder.models.xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class Box {

    private int id;

    @JsonProperty("Box")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Box> boxes = new ArrayList<Box>();

    @JsonProperty("Item")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Item> items = new ArrayList<Item>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}