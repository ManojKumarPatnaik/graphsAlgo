package com.epam.hometask.loops_Array;

public class CanBalance {
	public static boolean canBalance(int[] nums) {
		  int sum=0;
		  for(int i=0;i<nums.length;i++){
		    sum+=nums[i];
		    int res=0;
		    for(int j=nums.length-1;j>i;j--){
		    res+=nums[j];
		  }if(res==sum) return true;
		  }
		  return false;
		}

	public static void main(String[] args) {
		int[] array= {1, 1, 1, 2, 1};
		int[] array1= {2, 1, 1, 2, 1};
		int[] array2= {10, 10};
		System.out.println(canBalance(array));
		System.out.println(canBalance(array1));
		System.out.println(canBalance(array2));
	}

}
