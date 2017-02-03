package com.oracle.test.input;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.oracle.test.domain.DashboardInfo;
import com.oracle.test.domain.Person;
import com.oracle.test.domain.PersonEntry;

public class InputProcessor {

	DashboardInfo dashboard = DashboardInfo.getInstance();
	void process(Collection<PersonEntry> inputs){
		Map<Integer, Person> persons =dashboard.getPersonMap();
		for (PersonEntry personEntry : inputs) {
			Person person =persons.get(personEntry.getUid());
			if(person==null){
				person = new Person();
				person.setUid(personEntry.getUid());
				person.setFirstEntry(personEntry.getTime());
				person.setLastEntry(personEntry.getTime());
				person.setLastEntryType(personEntry.getEntryType());
				List<PersonEntry> list = new LinkedList<>();
				list.add(personEntry);
				person.setTodayEntry(list);
			}else{
				person.setLastEntry(personEntry.getTime());
				person.setLastEntryType(personEntry.getEntryType());
				person.getTodayEntry().add(personEntry);
			}
		}
	}
	
}
