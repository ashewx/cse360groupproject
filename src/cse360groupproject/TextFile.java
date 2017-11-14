package cse360groupproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class TextFile {
	private String name;
	private String input;
	private String date;
	private int numLines;
	private int blankLn;
	private int numSpaces;
	private int numWords;
	private int avgCharPerLn;
	private int avgWrdLen;
	private HashMap wordOccurence;
	private HashMap mostCommon;
	
	public TextFile(String name, String input) throws IOException {
		this.name = name;
		this.input = input;
		
		// Date created
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.date = dateFormat.format(date);
		
		// Calculations go here
		this.blankLn = calcBlank(input);
		this.numLines = lineCount(input);
		this.numSpaces = calcNumSpaces(input);
		this.numWords = calcNumWords(input);
		this.avgCharPerLn = calcAvgCharPerLn(input);
	}
	
	public int calcBlank(String input) throws IOException {
		BufferedReader br = new BufferedReader(new StringReader(input));
		String line;
		int empty = 0;
		while ((line = br.readLine()) != null) {
		  if (line.trim().isEmpty()) {
		    empty++;
		  }
		}
		return empty;
	}
	
	public String getName() {
		return name;
	}

	public String getInput() {
		return input;
	}

	public int getNumLines() {
		return numLines;
	}

	public int getBlankLn() {
		return blankLn;
	}

	
	public int getNumSpaces() {
		return numSpaces;
	}
	
	public int getNumWords() {
		return numWords;
	}
	
	public int getAvgCharPerLn() {
		return avgCharPerLn;
	}

	public int getAvgWrdLen() {
		return avgWrdLen;
	}

	public HashMap getMostCommon() {
		return mostCommon;
	}

	public HashMap getWordOccurence() {
		return wordOccurence;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public int calcAvgCharPerLn(String input) {
		
		int length = input.length();
		length = length - numSpaces;
		length = length/numLines;
		return length;
	}
	
	public int calcNumWords(String input) {
		
		if (input == null || input.isEmpty()) 
		{ 
			return 0; 
			} 
		String[] words = input.split("\\s+"); 
		return words.length;
	}
	
	public int lineCount(String filepath) throws IOException
	{
		BufferedReader reader = new BufferedReader(new StringReader(input));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();
		return lines;
	}
	
	public int calcNumSpaces(String input) {
		
		int count = 0;
		for (char c : input.toCharArray()) {
		    if (c == ' ') {
		         count++;
		    }
		}
		return count;
	}

}
