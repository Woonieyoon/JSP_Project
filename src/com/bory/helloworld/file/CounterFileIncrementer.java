package com.bory.helloworld.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CounterFileIncrementer {
	public static final String COUNTER_FILE_PATH = "C:/temp/countFile.txt";
	private File counterFile;
	
	public CounterFileIncrementer() {
		counterFile = new File(COUNTER_FILE_PATH);
		
	}
	public int incrementAndGet() {
		int currentValue = read();
		int newValue = currentValue+1;
		
		write(newValue);
		return currentValue;
	}
	private void write(int newValue) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(counterFile))){
			writer.write(String.valueOf(newValue));
			writer.flush();
		}catch(Exception e) {
			//ignored
		}
	}
	private int read() {
		int result = 0;
		try(BufferedReader reader = new BufferedReader(new FileReader(counterFile))){
			String line = reader.readLine();
			result = Integer.parseInt(line);
		}catch(Exception e) {
			//ignored
		}
		return result;
	}
}
