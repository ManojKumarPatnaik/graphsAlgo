package com.epam.hometask.loops_Array;

public class CountClumps {
	public static int countClumps(int[] nums) {
		  boolean match=false;
		  int count=0;
		  for(int i=0;i<nums.length-1;i++){
		    if(nums[i]==nums[i+1]&&!match){
		      match=true;
		      count++;
		    }else if (nums[i]!=nums[i+1]) {match=false;}
		  }return count;
		}

	public static void main(String[] args) {
		int[] array= {1, 2, 2, 3, 4, 4};
		int[] array1= {1, 1, 2, 1, 1};
		int[] array2= {1, 1, 1, 1, 1};
		System.out.println(countClumps(array));
		System.out.println(countClumps(array1));
		System.out.println(countClumps(array2));
	}

}
