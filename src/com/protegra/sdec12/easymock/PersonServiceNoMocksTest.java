package com.protegra.sdec12.easymock;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PersonServiceNoMocksTest {
	
	private PersonDao stubPersonDao = new PersonDao() {
		
		@Override
		public List<Person> getAllPeople() {
			return Arrays.asList(
				new Person("Bob", 20),
				new Person("Mary", 17)
			);
		}
	};
	
	@Test
	public void namesOfMinors() {
		PersonService testService = new PersonService(stubPersonDao);
		
		List<String> names = testService.getNamesForMinors();
		
		Assert.assertEquals(Arrays.asList("Mary"), names);
	}
}

