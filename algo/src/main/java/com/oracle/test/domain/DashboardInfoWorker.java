package com.oracle.test.domain;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.oracle.test.utility.DateUtility;

public class DashboardInfoWorker implements Worker {

	private final DashboardInfo dashboardInfo = DashboardInfo.getInstance();

	private static final float div = 60 * 60 * 1000;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oracle.test.domain.Worker#getNumberOfPersonsInOffice()
	 */
	@Override
	public long getNumberOfPersonsInOffice() {
		final Collection<Person> persons = dashboardInfo.getPersonMap().values();

		final long number = persons.stream().filter(p -> "Exit".equals(p.getLastEntryType())).count();
		return number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.oracle.test.domain.Worker#getNumberOfPersonsInOffice(java.util.Date,
	 * java.util.Date)
	 */
	@Override
	public long getNumberOfPersonsInOffice(Date start, Date end) {
		final Collection<Person> persons = dashboardInfo.getPersonMap().values();
		int count = 0;
		/*
		 * filter any entry of person which is not in the given range then
		 * remove it from the collection.
		 */
		for (Person p : persons) {
			Iterator<PersonEntry> iterator = p.getTodayEntry().listIterator();
			long totalHour = 0;
			/**
			 * We will check this by the inverse logic as if both the consecutive entry and
			 * exit are before the duration or after the duration if means
			 * he can not be in the office at that duration. So this is not true it
			 * means in all other condition, he was in the office in that duration.
			 */
			while (iterator.hasNext()) {
				PersonEntry first = iterator.next();
				if (!iterator.hasNext()
						&& (first.entryType.equals("Entry") && DateUtility.compareDate(first.time, end) < 0
								|| first.entryType.equals("Exit") && DateUtility.compareDate(first.time, end) > 0)) {
					totalHour = totalHour + (System.currentTimeMillis() - first.getTime().getTime());
					count++;
					break;
				}
				if (first.entryType.equals("Exit") && DateUtility.compareDate(first.time, end) > 0
						&& !iterator.hasNext()) {
					count++;
					break;
				}
				if(iterator.hasNext()){
					PersonEntry second = iterator.next();

					if (!(DateUtility.compareDate(first.time, start) < 0 && DateUtility.compareDate(second.time, start) < 0
							|| DateUtility.compareDate(first.time, start) > 0
									&& DateUtility.compareDate(second.time, start) > 0)) {
						count++;

					}
				}
				

			}
		}

		long number = persons.stream()
				.filter(p -> p.getTodayEntry().stream()
						.anyMatch(p1 -> !((start.getTime() < p1.time.getTime()) && (end.getTime() < p1.time.getTime())
								&& p1.entryType.equals("Entry"))
								|| !((start.getTime() > p1.time.getTime()) && (end.getTime() > p1.time.getTime())
										&& p1.entryType.equals("Exit"))))
				.count();
		return number;
	}

	public Person getPersonEntryBetweenTime(final int uid, Date from, Date to) {
		final Person p = dashboardInfo.getPersonMap().get(uid);
		/*
		 * remove the person entry if it is not in the range.
		 */
		p.getTodayEntry().stream().filter(
				e -> (DateUtility.compareDate(e.getTime(), from) < 0 && DateUtility.compareDate(e.getTime(), to) < 0));

		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oracle.test.domain.Worker#getNumberOfHourForPerson(int,
	 * java.util.Date, java.util.Date)
	 */
	@Override
	public float getNumberOfHourForPerson(final int uid, Date from, Date to) {
		final Person person = getPersonEntryBetweenTime(uid, from, to);
		if (person == null) {
			throw new RuntimeException("No person found with the given id!!");
		}

		Iterator<PersonEntry> iterator = person.getTodayEntry().listIterator();
		float totalHour = 0;
		/**
		 * Expect the entries to be in the order or entry and exit and calculate
		 * the difference and add it to number of hours.
		 */
		while (iterator.hasNext()) {
			PersonEntry entry = iterator.next();

			if (!iterator.hasNext()) {
				totalHour = totalHour + (System.currentTimeMillis() - entry.getTime().getTime());
				break;
			}
			PersonEntry exit = iterator.next();

			totalHour = totalHour + (exit.getTime().getTime() - entry.getTime().getTime());

		}

		return (totalHour / div) % 24;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oracle.test.domain.Worker#getNumberOfHourForPerson(int)
	 */
	@Override
	public float getNumberOfHourForPerson(final int uid) {
		final Person person = dashboardInfo.getPersonMap().get(uid);
		if (person == null) {
			throw new RuntimeException("No person found with the given id!!");
		}

		Iterator<PersonEntry> iterator = person.getTodayEntry().listIterator();
		long totalHour = 0;
		/**
		 * Expect the entries to be in the order or entry and exit and calculate
		 * the difference and add it to number of hours.
		 */
		while (iterator.hasNext()) {
			PersonEntry entry = iterator.next();

			if (!iterator.hasNext()) {
				totalHour = totalHour + (System.currentTimeMillis() - entry.getTime().getTime());
				break;
			}
			PersonEntry exit = iterator.next();

			totalHour = totalHour + (exit.getTime().getTime() - entry.getTime().getTime());

		}

		return (totalHour / div) % 24;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oracle.test.domain.Worker#findNumberOfEmployeeOverTime()
	 */
	@Override
	public long findNumberOfEmployeeOverTime() {
		final Collection<Person> persons = dashboardInfo.getPersonMap().values();
		/**
		 * Check number of person for each employee are not greater then 8 if
		 * yes then count it.
		 */
		long number = persons.stream().filter(p -> getNumberOfHourForPerson(p.getUd()) > 8).count();

		return number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.oracle.test.domain.Worker#findNumberOfEmployeeOverTime(java.util.
	 * Date, java.util.Date)
	 */
	@Override
	public long findNumberOfEmployeeOverTime(Date from, Date to) {
		final Collection<Person> persons = dashboardInfo.getPersonMap().values();
		long number = persons.stream().filter(p -> getNumberOfHourForPerson(p.getUd(), from, to) > 8).count();

		return number;
	}
}
