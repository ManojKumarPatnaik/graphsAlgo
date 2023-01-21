package com.buildappswithpauloapp.BuildFirstBootStrap;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;

import java.io.IOException;

@SpringUI(path = "")
public class MyView extends UI {


//    @Autowired
//    private Service service;

    @Autowired
    private ComplexService complexService;




    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);

        Label label = new Label();


        try {
            JSONArray myObj = complexService.getData();
            for (int i = 0; i < myObj.length(); i++) {

                try {
                    JSONObject postObject = myObj.getJSONObject(i);
                    System.out.println("Title: " + postObject.getString("title"));
                    System.out.println("Body: " + postObject.getString("body"));
                    System.out.println("UserId: " + postObject.getInt("userId"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


            System.out.println(myObj.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }


        //label.setValue(String.valueOf(service.showId()));


        layout.addComponent(label);


        setContent(layout);

    }

}
