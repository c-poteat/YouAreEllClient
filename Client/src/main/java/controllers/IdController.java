package controllers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.*;
import models.Id;


// takes in all info from IDs
// set up http client to connect to server

public class IdController {
    private HashMap<String, Id> allIds;
    private ObjectMapper objectMapper = new ObjectMapper();

    Id myId;

    public ArrayList<Id> getIds() {
        try {
            HttpClient client = HttpClient.newBuilder().build(); // creates new client
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://zipcode.rocks:8085/ids"))
                    .GET()
                    .build();
//                .header("Content-Type", "application/json")
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            List<Id> idList = objectMapper.readValue(response.body(), new TypeReference<List<Id>>() {
            });
            System.out.println(response.body());
            System.out.println(idList.get(0).getGithub());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }


    public Id postId(Id id) {
        // create json from id
        // call server, get json result Or error
        // result json to Id obj

        return null;
    }

    public Id putId(Id id) {
        return null;
    }

}