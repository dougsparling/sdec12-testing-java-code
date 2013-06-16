package com.protegra.sdec12.easymock;

import java.util.LinkedList;
import java.util.List;

public class PersonService {
	private PersonDao personDao;

	public PersonService(PersonDao personDao) {
		this.personDao = personDao;
	}

	public List<String> getNamesForMinors() {
		
		List<Person> allPersons = personDao.getAllPeople();
		
		List<String> names = new LinkedList<String>();
		for (Person person : allPersons) {
			if (person.getAge() < 18) {
				names.add(person.getName());
			}
		}
		
		return names;
	}
}
