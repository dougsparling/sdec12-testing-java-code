package com.protegra.sdec12.nicemock;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import com.protegra.sdec12.easymock.Person;

public class PersonExporter {
	private Logger logger;
	private ExportService exportService;

	public PersonExporter(Logger logger, ExportService exportService) {
		this.logger = logger;
		this.exportService = exportService;
	}

	public List<Person> exportPeople(List<Person> people) {
		
		List<Person> successful = new LinkedList<Person>();
		
		for (Person person : people) {
			if (exportService.export(person)) {
				logger.info("Successfully exported " + person.getName());
				successful.add(person);
			} else  {
				logger.warning("Could not export " + person.getName());
			}
		}
		return successful;
	}
}



