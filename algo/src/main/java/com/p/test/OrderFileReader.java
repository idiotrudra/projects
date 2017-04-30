package com.p.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class OrderFileReader {

	Processor<String> inputParser;
	
	public OrderFileReader(Processor<String> inputParser){
		this.inputParser=inputParser;
	}
	/**
	 * Reads file and parse it using parser.
	 * @param pathToFile
	 * @throws IOException
	 * @throws ParseException
	 */
	public void readFile(String pathToFile) throws IOException, ParseException{
		try (BufferedReader br = new BufferedReader(new FileReader(pathToFile)))
		{
			String line;
			while ((line = br.readLine()) != null) {
				inputParser.process(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
