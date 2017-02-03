package com.oracle.test.input;

import java.text.ParseException;
import java.util.Collection;

/**
 * Parser for Elements.
 * @author Hemant Gaur
 *
 * @param <T> element which needs to parsed.
 * @param <R> Result after parsing.
 */
public interface Parser<T, R> {

	/**
	 * Returns parsed object.
	 * @param input elements which needs to parsed.
	 * @return element after the parsing
	 * @throws ParseException 
	 */
	R parse(T input) throws ParseException;
	
	/**
	 * Parses collection of elements.
	 * @param inputs list of elements
	 * @return list of resolved object.
	 */
	Collection<R> parse(Collection<T> inputs) throws ParseException;
	
}
