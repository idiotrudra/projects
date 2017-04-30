package com.oracle.test.input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import com.oracle.test.domain.PersonEntry;

/**
 * 
 * Input parser for string to person object.
 * 
 * @author Hemant Gaur
 *
 */
public class InputStringParser implements Parser<String, PersonEntry> {

	public final String delimiter;
	public final int columns;

	public final static String FORMAT = "MM/dd/yyyy HH:mm:ss";

	public final static String FORMAT2 = "MM/dd/yyyy";

	public final static ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<>();
	public final static ThreadLocal<SimpleDateFormat> dateFormat2 = new ThreadLocal<>();

	{
		dateFormat.set(new SimpleDateFormat(FORMAT));
		dateFormat2.set(new SimpleDateFormat(FORMAT2));
	}

	public InputStringParser(String delimiter, int columns) {
		this.delimiter = delimiter;
		this.columns = columns;
	}

	/**
	 * Parse string and convert it into person entry object.
	 */
	@Override
	public PersonEntry parse(String input) throws ParseException {
		String[] details = input.split(delimiter, columns);
		String currentDate = dateFormat2.get().format(Calendar.getInstance().getTime());
		int uid = Integer.parseInt(details[0]);
		System.out.println(currentDate);
		System.out.println(currentDate + " " + details[1]);
		Date time = dateFormat.get().parse(currentDate + " " + details[1]);
		String entryType = details[2];
		return new PersonEntry(uid, time, entryType);
	}

	/**
	 * Parse a collection of strings.
	 */
	@Override
	public Collection<PersonEntry> parse(Collection<String> inputs) throws ParseException {

		Collection<PersonEntry> persons = new ArrayList<>(inputs.size());

		for (String input : inputs) {
			persons.add(parse(input));
		}
		return persons;
	}

}
