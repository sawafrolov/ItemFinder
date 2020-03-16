package com.github.sawafrolov.itemfinder.models.request;

public class FindRequestBody {

    private int box;

    private String color;

    public FindRequestBody(int box, String color) {
        this.box = box;
        this.color = color;
    }

    public int getBox() {
        return box;
    }

    public String getColor() {
        return color;
    }
}