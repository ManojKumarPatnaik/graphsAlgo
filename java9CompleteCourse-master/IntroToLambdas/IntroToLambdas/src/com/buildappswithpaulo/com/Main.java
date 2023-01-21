package com.buildappswithpaulo.com;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


class Product{
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
public class Main {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        //Add products
        list.add(new Product(1,"MacBookPro", 2200));
        list.add(new Product(2, "iPhone 7", 700));
        list.add(new Product(3, "Google Pixel Phone", 700));
        list.add(new Product(4, "TV ", 7000));


        System.out.println("Before filter applied");
        list.forEach(
                (product) -> System.out.println(product.name
                        + " " +product.price)
        );


        System.out.println("======================");

        Stream<Product> filteredData = list.stream().filter(
                product -> product.price > 600);

        System.out.println("Filter applied....");

        filteredData.forEach(
                product -> System.out.println(product.name
                        + " " +product.price)
       );

//        for (Product p : list) {
//            System.out.println(p.id+ " " + p.name + " " + p.price);
//        }
//
//        System.out.println("=========================");
//
//        System.out.println("Sorting on the basis of name...");
//
//        Collections.sort(list, Comparator.comparing(p -> p.name));
//
//        for (Product p : list) {
//            System.out.println(p.id+ " " + p.name + " " + p.price);
//        }

















//        Speakable speakable = (message) -> {
//            String message1 = "Hello World";
//            String message2 = message + message1  + " Another Message";
//
//            return message2;
//
//        };
//        System.out.println(speakable.speak("Here it goes.."));






//
//        List<String> nameList = new ArrayList<>();
//        nameList.add("Bonni");
//        nameList.add("Paulo");
//        nameList.add("James");
//        nameList.add("Denise");
//        nameList.add("Chuck");
//        nameList.add("Gina");
//
//        nameList.forEach(
//                (names) -> System.out.println(names)
//        );

//        for (String names : nameList) {
//            System.out.println(names);
//        }







//        Addable addable = (a,b)->(a+b);
//        System.out.println(addable.add(12, 12));
//
//        Addable addable1 = ((int a, int b) -> (a+b));
//        System.out.println(addable1.add(10, 12));
















//        Drawable drawable = (width, height)
//                -> System.out.println("Drawing - width: " + width
//                 + " Height: " + height);
//
//        drawable.draw(23, 12);


//        Drawable drawable = new Drawable() {
//            @Override
//            public void draw() {
//                System.out.println("Drawing");
//
//            }
//        };
//        drawable.draw();


    }


}

interface Speakable{
    String speak(String message);
}
interface Addable{
    int add(int a, int b);
}
interface Drawable {
     void draw(int width, int height);

}




