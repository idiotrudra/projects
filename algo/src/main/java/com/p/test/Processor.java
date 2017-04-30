package com.p.test;

import java.text.ParseException;
/**
 * 
 * @author hemant
 *
 * @param <T>
 */
public interface Processor<T> {

/**
 * 
 * @param input
 * @throws ParseException
 */
	void process(T input) throws ParseException;

	void complete();
	
}
