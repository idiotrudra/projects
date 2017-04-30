package com.oracle.test.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * File reader to read object from the file with the help of provided parser.
 * @author hemant gaur
 *
 * @param <T>
 */
public class DashboardFileReader<T> {
	Parser<String, T> inputParser;
	
	public DashboardFileReader(Parser<String, T> inputParser){
		this.inputParser=inputParser;
	}
	/**
	 * Reads file and parse it using parser.
	 * @param pathToFile
	 * @return collection of object using parser.
	 * @throws IOException
	 * @throws ParseException
	 */
	public Collection<T> readFile(String pathToFile) throws IOException, ParseException{
		Collection<T> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(pathToFile)))
		{
			String line;
			//ignore first line
			br.readLine();
			while ((line = br.readLine()) != null) {
				list.add(inputParser.parse(line));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
