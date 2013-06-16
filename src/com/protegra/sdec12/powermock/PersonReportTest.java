package com.protegra.sdec12.powermock;

import java.util.Arrays;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.protegra.sdec12.coverage.FileUtil;
import com.protegra.sdec12.easymock.Person;
import com.protegra.sdec12.tdd.NameSplitter;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FileUtil.class,PersonReport.class,NameSplitter.class})
public class PersonReportTest {
	
	@Test
	public void writeReport() throws Exception {
		
		NameSplitter mockSplitter = PowerMock.createMock(NameSplitter.class);
		PowerMock.expectNew(NameSplitter.class, "Doug Hiebert").andReturn(mockSplitter);
		EasyMock.expect(mockSplitter.getFirstName()).andReturn("Doug");
		EasyMock.expect(mockSplitter.getLastName()).andReturn("Hiebert");
		
		PowerMock.mockStatic(FileUtil.class);
		EasyMock.expect(FileUtil.writeLines("C:\temp.txt", Arrays.asList("18,Doug,Hiebert"))).andReturn(true);
		
		PowerMock.replayAll();
		PersonReport report = new PersonReport();
		report.writeReport(Arrays.asList(new Person("Doug Hiebert",18)), "C:\temp.txt");
		PowerMock.verifyAll();
	}
}
