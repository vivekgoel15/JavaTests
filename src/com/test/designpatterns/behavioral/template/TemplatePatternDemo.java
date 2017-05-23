package com.test.designpatterns.behavioral.template;

/**
 * Define the skeleton of an algorithm in an operation, deferring some steps to
 * subclasses. Template Method lets subclasses redefine certain steps of an
 * algorithm without letting them to change the algorithm's structure.
 * 
 * e.g. HttpServlet.doService() -> doGet, doPost()
 * 
 * @author vigoel
 *
 */
public class TemplatePatternDemo {

	public static void main(String[] args) {

		CSVDataParser csvDataParser = new CSVDataParser();
		csvDataParser.parseDataAndGenerateOutput();
		System.out.println("**********************");
		DatabaseDataParser databaseDataParser = new DatabaseDataParser();
		databaseDataParser.parseDataAndGenerateOutput();
	}
}

abstract class DataParser {

	// Template method
	// This method defines a generic structure for parsing data
	public void parseDataAndGenerateOutput() {
		readData();
		processData();
		writeData();
	}

	// This methods will be implemented by its subclass
	abstract void readData();

	abstract void processData();

	// We have to write output in a CSV file so this step will be same for all
	// subclasses
	public void writeData() {
		System.out.println("Output generated, writing to CSV");
	}
}

class CSVDataParser extends DataParser {

	void readData() {
		System.out.println("Reading data from csv file");
	}

	void processData() {
		System.out.println("Looping through loaded csv file");
	}
}

class DatabaseDataParser extends DataParser {

	void readData() {
		System.out.println("Reading data from database");
	}

	void processData() {
		System.out.println("Looping through datasets");
	}
}