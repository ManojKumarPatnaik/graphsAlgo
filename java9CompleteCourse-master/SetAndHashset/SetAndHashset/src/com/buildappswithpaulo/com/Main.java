package com.buildappswithpaulo.com;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int count[] = {3,6,5,9,10,23};


        //set
        Set<Object> set = new HashSet<>();

        try{
//             set.add("Potatoes");
//             set.add("Bananas");
//             set.add("Oranges");
//             set.add("Pears");
//            for (int i = 0; i < count.length; i++){
//                set.add(count[i]);
//            }
            //TreeSet
            TreeSet sortedSet = new TreeSet(set);

            //LinkedHashSet
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
            linkedHashSet.add("Movie");
            linkedHashSet.add("Potato");
            linkedHashSet.add("James");
            linkedHashSet.add("Now");
            linkedHashSet.add("Java");

            Iterator<String> iterator = linkedHashSet.iterator();

            while (iterator.hasNext()) {
                System.out.println("Items " + iterator.next());
            }


           // System.out.println("Sorted List:" + sortedSet);


















//            System.out.println("Our set" + set);
//            System.out.println("Size" + set.size());
//            set.remove(count[0]);
//            System.out.println("Our set" + set);
//            System.out.println("Size" + set.size());



//            if (set.contains(3)) {
//                System.out.println("Yes");
//
//            }else System.out.println("Nope");


        }catch (Exception e){}


    }
}
