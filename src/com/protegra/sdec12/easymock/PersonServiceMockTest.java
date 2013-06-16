package com.protegra.sdec12.easymock;

import static junit.framework.Assert.assertEquals;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Test;

public class PersonServiceMockTest {
	
	@Test
	public void namesOfMinors() {
		
		PersonDao mockPersonDao = createMock(PersonDao.class);
		expect(mockPersonDao.getAllPeople()).andReturn(Arrays.asList(
			new Person("Mary", 17),
			new Person("Tom", 18)
		));
		
		PersonService testService = new PersonService(mockPersonDao);
		
		replay(mockPersonDao);
		List<String> names = testService.getNamesForMinors();
		verify(mockPersonDao);
		
		assertEquals(Arrays.asList("Mary"), names);
	}
}


