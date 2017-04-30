package com.oracle.test.utility;

import java.util.Calendar;
import java.util.Date;

public class DateUtility {

	public static int compareDate(Date date1, Date date2){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(date2);
		
		if (c1.get(Calendar.YEAR) != c2.get(Calendar.YEAR)) 
	        return c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
	    if (c1.get(Calendar.MONTH) != c2.get(Calendar.MONTH)) 
	        return c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
	    return c1.get(Calendar.DAY_OF_MONTH) - c2.get(Calendar.DAY_OF_MONTH);
	}
}
