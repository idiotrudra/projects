package com.oracle.test.domain;

import java.util.Date;

public interface Worker {

	/**
	 * returns number of person in the office.
	 * 
	 * @return
	 */
	long getNumberOfPersonsInOffice();

	long getNumberOfPersonsInOffice(Date start, Date end);

	float getNumberOfHourForPerson(int uid, Date from, Date to);

	float getNumberOfHourForPerson(int uid);

	long findNumberOfEmployeeOverTime();

	long findNumberOfEmployeeOverTime(Date from, Date to);

}