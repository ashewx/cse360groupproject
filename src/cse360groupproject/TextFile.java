package cse360groupproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class TextFile {
	private String name;
	private String input;
	private int numLines;
	private int blankLn;
	private int numSpaces;
	private int numWords;
	private int avgCharPerLn;
	private int avgWrdLen;
	
	public TextFile(String name, String input) throws IOException {
		this.name = name;
		this.input = input;
		this.blankLn = calcBlank(input);
		this.numLines = lineCount(input);
		this.numSpaces = getNumSpaces(input);
		this.numWords = getNumWords(input);
		this.avgCharPerLn = getAvgCharPerLn(input);
		
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

	public int getNumSpaces(String input) {
		
		int count = 0;
		for (char c : input.toCharArray()) {
		    if (c == ' ') {
		         count++;
		    }
		}
		return count;
	}

	public int getNumWords(String input) {
		
		if (input == null || input.isEmpty()) 
		{ 
			return 0; 
			} 
		String[] words = input.split("\\s+"); 
		return words.length;
	}

	public int getAvgCharPerLn(String input) {
		
		int length = input.length();
		length = length - numSpaces;
		length = length/numLines;
		avgCharPerLn = length;
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
	
	
	public int lineCount(String filepath) throws IOException
	{
		BufferedReader reader = new BufferedReader(new StringReader(input));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();
		return lines;
	}
	

}
