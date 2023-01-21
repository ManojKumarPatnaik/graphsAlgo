package com.buildappswithpauloapp.BuildFirstBootStrap;

import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class Service {

    RestTemplate restTemplate = new RestTemplate();
    private String url = "https://jsonplaceholder.typicode.com/posts/1";
    private String url2 = "https://jsonplaceholder.typicode.com/posts";
    // We're mapping our Post model to the JSON object from remote place


    Post post = restTemplate.getForObject(url, Post.class);


    int showUserId() {
        return post.getUserId();
    }

    int showId() {
        return post.getId();
    }

    String showTitle() {
        return post.getTitle();
    }

    String showBody() {
        return post.getBody();
    }

    String showName(String name) {

        return name;

    }
}
