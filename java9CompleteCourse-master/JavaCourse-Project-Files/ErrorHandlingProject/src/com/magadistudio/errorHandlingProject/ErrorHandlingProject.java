package com.magadistudio.errorHandlingProject;

public class ErrorHandlingProject {

	public static void main(String[] args) {
		
		
		int number[] = { 4, 8, 16, 32, 64, 128, 256, 512 };
		int denom[] = { 2, 0, 4, 4, 0, 8 };
		 
		for (int i = 0; i < number.length; i++) {
			try {
				
				System.out.println(number[i] + " / " + denom[i] + " is " + number[i]/denom[i]);
				
				
			} catch (ArithmeticException e) {
				
				 System.out.println("Cant Divide by zero");
				 
			}catch (ArrayIndexOutOfBoundsException e) {
				
				System.out.println(" No matching element found");
				
			} finally {
				// will always run!
				System.out.println("Running!!!");
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		float sum = 0;
//		
//		for (String argument : args) {
//			
//			try {
//				
//				sum = sum + Float.parseFloat(argument);
//				
//			} catch (NumberFormatException e) {
//				
//				System.out.print("Exception message: " + e.getMessage());
//				System.out.print(argument + " is not a number");
//				
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//			} 
//			
//		}
//		
//		System.out.println("Sum is: " + sum);
		
	}

}
