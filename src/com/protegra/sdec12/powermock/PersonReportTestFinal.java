package com.protegra.sdec12.powermock;

import java.util.Arrays;
import java.util.List;

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
public class PersonReportTestFinal {
	
	@Test
	public void writeReport() throws Exception {
		
		String fakeName = "Fake Name";
		String fakePath = "/fake/path.txt";
		
		NameSplitter mockNameSplitter = PowerMock.createMock(NameSplitter.class);
		PowerMock.expectNew(NameSplitter.class, fakeName).andReturn(mockNameSplitter);
		
		EasyMock.expect(mockNameSplitter.getFirstName()).andReturn("First");
		EasyMock.expect(mockNameSplitter.getLastName()).andReturn("Last");
		
		PowerMock.mockStatic(FileUtil.class);
		EasyMock.expect(FileUtil.writeLines(fakePath, Arrays.asList("21,First,Last"))).andReturn(true);
		
		PersonReport personReport = new PersonReport();
		List<Person> testData = Arrays.asList(new Person(fakeName, 21));
		
		PowerMock.replayAll();
		personReport.writeReport(testData, fakePath);
		PowerMock.verifyAll();
	}
}
