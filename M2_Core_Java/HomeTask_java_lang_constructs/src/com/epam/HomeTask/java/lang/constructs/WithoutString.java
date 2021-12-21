package com.epam.HomeTask.java.lang.constructs;

public class WithoutString {
	public static String withoutString(String base, String remove) {
			  base=base.replace(remove.toUpperCase(),"");
			base=base.replace(remove.toLowerCase(),"");
			return base.replace(remove,"");
	}


	public static void main(String[] args) {
		System.out.println(withoutString("Hello there", "llo"));
		System.out.println(withoutString("Hello there", "e"));
		System.out.println(withoutString("Hello there", "X"));
	}

}
