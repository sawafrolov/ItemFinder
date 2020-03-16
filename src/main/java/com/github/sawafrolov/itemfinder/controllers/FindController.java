package com.github.sawafrolov.itemfinder.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sawafrolov.itemfinder.models.request.FindRequestBody;
import com.github.sawafrolov.itemfinder.util.finder.StorageFinder;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FindController {

    @Autowired
    private StorageFinder finder;

    @Autowired
    private Gson gson;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/find")
    public String find(@RequestBody String json) throws Exception {
        FindRequestBody requestBody = gson.fromJson(json, FindRequestBody.class);
        int boxId = requestBody.getBox();
        String color = requestBody.getColor();
        ArrayList<Integer> list = finder.findItems(boxId, color);
        String result = objectMapper.writeValueAsString(list);
        return result;
    }
}