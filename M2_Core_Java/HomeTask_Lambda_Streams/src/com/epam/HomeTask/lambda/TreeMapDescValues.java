package com.epam.HomeTask.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDescValues {
	@SuppressWarnings("unchecked")
	public static <k,V extends Comparable <V>, K>Map<k,V>
	sortByValues(final Map<K,V>map){
		Comparator<K> valu=new Comparator<K>() {
			public int compare(K k1,K k2) {
				int compare=map.get(k1).compareTo(map.get(k2));
				if (compare == 0)  return 1;
				else return compare;
			}
		};
		Map<K,V> sortedByValues=new TreeMap<K,V>(valu);
		sortedByValues.putAll(map);
		return (Map<k, V>) sortedByValues;
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		TreeMap<String,String> treemap=new TreeMap<>(Collections.reverseOrder());
		treemap.put("Manoj","1");
		treemap.put("kumar","2");
		treemap.put("Ravi","3");
		treemap.put("ajeet","4");
		Map sortedMap = sortByValues(treemap);
		 
		    // Get a set of the entries on the sorted map
		    Set set = sortedMap.entrySet();
		 
		    // Get an iterator
		    Iterator i = set.iterator();
		 
		    // Display elements
		    while(i.hasNext()) {
		      Map.Entry me = (Map.Entry)i.next();
		      System.out.print(me.getKey() + ": ");
		      System.out.println(me.getValue());
		    }
	}

}
