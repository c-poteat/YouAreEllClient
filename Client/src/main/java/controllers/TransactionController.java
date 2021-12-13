package controllers;

import okhttp3.*;

import java.io.IOException;

public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085/";
    private OkHttpClient client;
    private MediaType mediaType;

    public TransactionController() {
        client = new OkHttpClient();
        mediaType = MediaType.parse("application/json");
    }

    //    public MessageController getMsgCtrl() {
//        return msgCtrl;
//    }
//
//    public IdController getIdCtrl() {
//        return idCtrl;
//    }
    // Building a URL request for get.
    public Response get(String path) throws IOException {
        Request request = new Request.Builder()
                .url(rootURL + path)
                .method("GET", null)
                //.addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
        return null;
    }

    // Building a URL request for posting.
    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url(rootURL + url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String makecall(String s, String get, String s1) {
        return "";
    }
}
