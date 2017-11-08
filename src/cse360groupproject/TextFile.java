package cse360groupproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public TextFile(String name, String input) throws IOException {
		this.name = name;
		this.input = input;
		
		// Date created
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.date = dateFormat.format(date);
		
		// Calculations go here
		this.blankLn = calcBlank(input);
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

	public void setName(String name) {
		this.name = name;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public void setNumLines(int numLines) {
		this.numLines = numLines;
	}

	public void setBlankLn(int blankLn) {
		this.blankLn = blankLn;
	}

	public void setNumSpaces(int numSpaces) {
		this.numSpaces = numSpaces;
	}

	public void setNumWords(int numWords) {
		this.numWords = numWords;
	}

	public void setAvgCharPerLn(int avgCharPerLn) {
		this.avgCharPerLn = avgCharPerLn;
	}

	public void setAvgWrdLen(int avgWrdLen) {
		this.avgWrdLen = avgWrdLen;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
