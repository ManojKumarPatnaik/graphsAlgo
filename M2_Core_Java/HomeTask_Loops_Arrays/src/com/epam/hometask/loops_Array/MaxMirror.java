package com.epam.hometask.loops_Array;

public class MaxMirror {
	public int maxMirror(int[] nums) {
		  int count=0,max=0;
		  for(int i=0;i<nums.length;i++){
		    for(int j=nums.length-1;i+count<nums.length&&j>-1;j--){
		      if(nums[i+count]==nums[j]){
		        count++;
		      }else {
		        if(count>0){
		          max=Math.max(count,max);
		          count=0;
		        }
		      }
		    }max=Math.max(count,max);
		  }return max;
		}


	public static void main(String[] args) {
		

	}

}
