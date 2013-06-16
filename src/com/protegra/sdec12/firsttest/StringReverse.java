package com.protegra.sdec12.firsttest;

public class StringReverse {
	
	public static String reverse(String str) {
		
		int length = str.length();
		char[] reversed = new char[length];
		
		for (int i = 0; i < length; i++) {
			reversed[length - i - 1] = str.charAt(i);
		}
		
		return new String(reversed);
	}
	
}
