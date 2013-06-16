package com.protegra.sdec12.powermock;

import java.util.ArrayList;
import java.util.List;

import com.protegra.sdec12.coverage.FileUtil;
import com.protegra.sdec12.easymock.Person;
import com.protegra.sdec12.tdd.NameSplitter;

public class PersonReport {
	public void writeReport(List<Person> people, String reportPath) {
		
		List<String> reportLines = new ArrayList<String>(people.size());
		
		for (Person person : people) {

			NameSplitter splitter = new NameSplitter(person.getName());
			
			reportLines.add("" + 
					person.getAge() + "," +
					splitter.getFirstName() + "," +
					splitter.getLastName());
		}
		
		FileUtil.writeLines(reportPath, reportLines);
	}
}

