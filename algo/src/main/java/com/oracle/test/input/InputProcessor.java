package com.oracle.test.input;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.oracle.test.domain.DashboardInfo;
import com.oracle.test.domain.Person;
import com.oracle.test.domain.PersonEntry;

/**
 * Processes input and adds it to our map to store all the data in memory.
 * 
 * @author hemant gaur
 *
 */
public class InputProcessor {

	private static DashboardInfo dashboard = DashboardInfo.getInstance();

	/**
	 * process this data and add it to our in memory for storing data in the
	 * application.
	 * 
	 * @param inputs
	 */
	public void process(Collection<PersonEntry> inputs) {
		Map<Integer, Person> persons = dashboard.getPersonMap();
		for (PersonEntry personEntry : inputs) {
			Person person = persons.get(personEntry.getUid());
			if (person == null) {
				person = new Person();
				person.setUid(personEntry.getUid());
				person.setFirstEntry(personEntry.getTime());
				person.setLastEntry(personEntry.getTime());
				person.setLastEntryType(personEntry.getEntryType());
				List<PersonEntry> list = new LinkedList<>();
				list.add(personEntry);
				person.setTodayEntry(list);
				persons.put(person.getUd(), person);
			} else {
				if (person.getLastEntryType().equals(personEntry.getEntryType())
						&& "Entry".equals(personEntry.getEntryType())) {
					continue;
				} else if (!person.getLastEntryType().equals(personEntry.getEntryType())
						&& "Exit".equals(personEntry.getEntryType())) {
					person.getTodayEntry().remove(person.getTodayEntry().size() - 1);
					person.setLastEntry(personEntry.getTime());
					person.setLastEntryType(personEntry.getEntryType());
					person.getTodayEntry().add(personEntry);
				}else{
					person.setLastEntry(personEntry.getTime());
					person.setLastEntryType(personEntry.getEntryType());
					person.getTodayEntry().add(personEntry);
				}

			}
		}
	}

}
