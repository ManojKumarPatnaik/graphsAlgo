package com.buildappswithpauloapp.BuildFirstBootStrap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

@org.springframework.stereotype.Service
public class ComplexService {
    private String postUrl = "https://jsonplaceholder.typicode.com/posts";

    OkHttpClient client = new OkHttpClient();
    Response response;

    public JSONArray getData() throws IOException {

        Request request = new Request.Builder()
                .url(postUrl)
                .build();

        response = client.newCall(request).execute();
        try {
            return  new JSONArray(response.body().string());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }








}
