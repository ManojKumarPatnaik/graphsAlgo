package com.magadistudio.hashmaps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class hashMapsProject {

	public static void main(String[] args) {
		
		
		HashMap users = new HashMap<>();
		
		HashMap<String, Integer> newUser = new HashMap<>();
		
		newUser.put("Sue", 34);
		
		
		System.out.println(newUser.get("Sue"));
		
		
		
		users.put("Kealy", 34);
		users.put("Bonni", 25);
		
		if (users.containsKey("Life")) {
			
			System.out.println("yay");
			
		}else {
			
			System.out.println("Nay!");
		}
		
		
		
		
		
		Iterator it = users.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			
			System.out.println(pair.getKey() + " = " + pair.getValue());
		}
		
//		System.out.println("Values : " + users.values());
//		System.out.println("Entire values: " + users.entrySet());
		
	
	

//		System.out.println(users.get("Kealy"));
//		System.out.println(users.get("Bonni"));
		
		
		
			

	}

}
