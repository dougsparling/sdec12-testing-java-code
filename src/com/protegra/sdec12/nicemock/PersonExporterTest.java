package com.protegra.sdec12.nicemock;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import com.protegra.sdec12.easymock.Person;

public class PersonExporterTest {
	
	@Test
	public void exportPersons() {
		ExportService mockExportService = EasyMock.createMock(ExportService.class);
		Logger mockLogger = EasyMock.createNiceMock(Logger.class);
		
		Person bob  = new Person("Bob",  25);
		Person sue  = new Person("Sue",  40);
		Person jake = new Person("Jake", 20);
		
		EasyMock.expect(mockExportService.export(EasyMock.eq(sue))).andReturn(false);
		
		EasyMock.expect(mockExportService.export(EasyMock.not(EasyMock.eq(sue))))
			.andReturn(true).times(2);
		
		mockLogger.warning("Could not export Sue");
		
		PersonExporter exporter = new PersonExporter(mockLogger, mockExportService);
		
		EasyMock.replay(mockExportService, mockLogger);
		List<Person> exported = exporter.exportPeople(Arrays.asList(bob, sue, jake));
		EasyMock.verify(mockExportService, mockLogger);
		
		Assert.assertEquals(Arrays.asList(bob, jake), exported);
	}
	
	
}
