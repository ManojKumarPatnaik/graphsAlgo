package com.epam.HomeTask.lambda;

import java.util.ArrayList;
import java.util.Collections;
class SecondBiggestNumber {

	public static void main(String[] args) {
		ArrayList<Integer> list= new ArrayList<Integer>();
		list.add(109);
		list.add(99);
		list.add(100);
		list.add(98);
		list.add(92);
		list.add(73);
		list.add(110);
		list.add(28);
		//Using lambda expressions 
		Collections.sort(list,Collections.reverseOrder());
		list.forEach(n->{if(n==list.get(2))System.out.println("Second biggest number in the given list with using lambda expression = "+list.get(1));});
		//Without Using lambda expressions 
		Collections.sort(list);
		System.out.println("Second biggest number in the given list without using lambda expression = "+list.get(list.size()-2));
	}

}