package com.epam.hometask.loops_Array;

public class MaxSpan {
	public static int maxSpan(int[] nums) {
		int span = 0, num = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					num = j - i + 1;
					span = Math.max(num, span);
				}
			}
		}
		return span;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 1, 1, 3 };
		int[] array1 = { 1, 4, 2, 1, 4, 1, 4 };
		int[] array2 = { 1, 4, 2, 1, 4, 4, 4 };
		System.out.println(maxSpan(array));
		System.out.println(maxSpan(array1));
		System.out.println(maxSpan(array2));

	}

}
