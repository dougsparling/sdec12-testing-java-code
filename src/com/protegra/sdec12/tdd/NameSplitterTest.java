package com.protegra.sdec12.tdd;

import junit.framework.Assert;

import org.junit.Test;

public class NameSplitterTest {

	@Test
	public void testSplitSimpleName()
	{
		NameSplitter testSplitter = new NameSplitter("Doug Hiebert");
		Assert.assertEquals("Doug", testSplitter.getFirstName());
		Assert.assertEquals("Hiebert", testSplitter.getLastName());
	}
	
	@Test
	public void testSplitComplexName()
	{
		NameSplitter testSplitter = new NameSplitter("Doug G. Hiebert");
		Assert.assertEquals("Doug G.", testSplitter.getFirstName());
		Assert.assertEquals("Hiebert", testSplitter.getLastName());
	}
}
