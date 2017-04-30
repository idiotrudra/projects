package com.p.test;

import java.io.IOException;
import java.text.ParseException;

public class Demo {

	public static void main(String[] order) throws IOException, ParseException{
		//String[] order= {"/home/rudra/sample_data.csv", "burger", "tofu_log"};
		Processor<String> processor = new OrderProcessor(order);
		OrderFileReader fileReader = new OrderFileReader(processor);
		fileReader.readFile(order[0]);
		processor.complete();
	}
	
}
