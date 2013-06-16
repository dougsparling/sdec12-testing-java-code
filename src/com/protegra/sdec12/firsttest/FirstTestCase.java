package com.protegra.sdec12.firsttest;

public class FirstTestCase {
	
	public static void main(String... args) {
		
		String firstExample = "abcde";
		String firstReversed = StringReverse.reverse(firstExample);
		
		System.out.println("First: '" + firstExample
				+ "', Reversed: '" + firstReversed + "'");
		
		boolean firstAsExpected = firstReversed.equals("edcba");
		
		System.out.println("As expected? " + firstAsExpected);
	}
}




