package com.oracle.test.domain;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class DashboardInfoProcessor {

	final DashboardInfo dashboardInfo = DashboardInfo.getInstance();

	final int div = 60 * 60 * 1000;
	public long getNumberOfPersonsInOffice() {
		final Collection<Person> persons = dashboardInfo.getPersonMap().values();

		final long number = persons.stream().filter(p -> p.getLastEntryType() == "Entry").count();
		return number;
	}

	public long getNumberOfPersonsInOffice(Date start, Date end) {
		final Collection<Person> persons = dashboardInfo.getPersonMap().values();

		long number = persons.stream()
				.filter(p -> p.getTodayEntry().stream()
						.anyMatch(p1 -> !((start.getTime() < p1.time.getTime()) && (end.getTime() < p1.time.getTime())
								&& p1.entryType.equals("Entry"))
								|| !((start.getTime() > p1.time.getTime()) && (end.getTime() > p1.time.getTime())
										&& p1.entryType.equals("Exit"))))
				.count();
		return number;
	}

	public long getNumberOfHourForPerson(final int uid) {
		final Person person = dashboardInfo.getPersonMap().get(uid);
		if (person == null) {
			throw new RuntimeException("No person found with the given id!!");
		}

		Iterator<PersonEntry> iterator = person.getTodayEntry().listIterator();
		long totalHour =0;
		
		while(iterator.hasNext()){
			PersonEntry entry = iterator.next();
			
			if(!iterator.hasNext()){
				totalHour =totalHour+( System.currentTimeMillis() - entry.getTime().getTime());
				break;
			}
			PersonEntry exit = iterator.next();
			
			totalHour = totalHour+ (exit.getTime().getTime()- entry.getTime().getTime());
						
		}
		
		return (totalHour/div)%24;
	}

	public long findNumberOfEmployeeOverTime() {
		final Collection<Person> persons = dashboardInfo.getPersonMap().values();
		long number = persons.stream()
				.filter(p -> getNumberOfHourForPerson(p.getUd()) > 8).count();

		return number;
	}
}
