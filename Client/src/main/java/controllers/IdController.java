package controllers;

import java.io.IOException;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.*;

import com.google.gson.Gson;
import models.Id;


// takes in all info from IDs
// set up http client to connect to server

public class IdController {
    private HashMap<String, Id> allIds;
    private ObjectMapper objectMapper = new ObjectMapper();
    private TransactionController tc = new TransactionController();

    Id myId;

    public String getIds() {
        String data = "";
        try {
            data = tc.get("ids").body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
        public Id postId(Id id) throws IOException {
            String payload = new Gson().toJson(id);
            tc.post("ids",payload);
            return id;
        }

    public Id putId(Id id) {
        return null;
    }
}