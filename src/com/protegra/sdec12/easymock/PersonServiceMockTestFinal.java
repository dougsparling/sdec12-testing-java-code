package com.protegra.sdec12.easymock;

import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

public class PersonServiceMockTestFinal {

	@Test
	public void namesOfMinors() {
		
		PersonDao mockPersonDao = EasyMock.createMock(PersonDao.class);
		
		EasyMock.expect(mockPersonDao.getAllPeople()).andReturn(Arrays.asList(
			new Person("Bob", 18),
			new Person("Mary", 17)
		));
		
		PersonService testService = new PersonService(mockPersonDao);
		
		EasyMock.replay(mockPersonDao);
		
		List<String> names = testService.getNamesForMinors();
		
		EasyMock.verify(mockPersonDao);
		
		Assert.assertEquals(Arrays.asList("Mary"), names);
	}
}


