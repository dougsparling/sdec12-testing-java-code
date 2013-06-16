package com.protegra.sdec12.firsttest;

import org.junit.Assert;
import org.junit.Test;

public class StringReverseTest {
	
	@Test
	public void reverseString() {
		String reversed = StringReverse.reverse("abcde");
		Assert.assertEquals("edcba", reversed);
	}
	
	@Test
	public void reverseSingleChar() {
		Assert.assertEquals("Reversing should have no effect on single characters.", "a", StringReverse.reverse("a"));
	}
	
	@Test
	public void reverseEmpty() {
		Assert.assertEquals("", StringReverse.reverse(""));
	}
}