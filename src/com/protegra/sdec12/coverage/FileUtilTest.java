package com.protegra.sdec12.coverage;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileUtilTest {
	
	private String testFilePath = System.getProperty("java.io.tmpdir") + File.pathSeparator + "path.txt";
	private String lineSeparator = System.getProperty("line.separator");
	
	@Before
	@After
	public void deleteTempFile() {
		new File(testFilePath).delete();
	}
	
	@Test
	public void writeLinesHappyPath() throws Exception {
		
		FileUtil.writeLines(testFilePath, Arrays.asList("hello", "world"));
		
		Assert.assertTrue(new File(testFilePath).exists());
		String expectedContents = "hello" + lineSeparator + "world" + lineSeparator;
		String testFileContents = new Scanner( new File(testFilePath) ).useDelimiter("\\A").next();
		Assert.assertEquals(expectedContents, testFileContents);
	}
}
