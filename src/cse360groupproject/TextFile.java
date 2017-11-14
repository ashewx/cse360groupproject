package cse360groupproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
	private Map<String, Integer> wordOccurrence;
	
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
		this.avgWrdLen = calcAvgWordLen(input);
		this.wordOccurrence = calcOccurrences(input);
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

	public Map<String, Integer> getWordOccurrence() {
		return wordOccurrence;
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
		String[] words = input.split("\\W+"); 
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
	
	//TODO avoid punctuation and lowercase!!!
	public int calcAvgWordLen(String input) {
		String[] wordList = input.split("\\W+");
		int totalChars = 0;
		for(String i : wordList)
		{
			totalChars += i.length();
		}
		int words = wordList.length;
		int average = (int)(totalChars/words);
		return average;
	}
	
	// Returns a Map of sorted occurrences in descending order
	public Map<String, Integer> calcOccurrences(String input) {
		String lowerCase = input.toLowerCase(); // Set to lowercase
		String[] wordList = lowerCase.split("\\W+"); // Separate by non-word char
		HashMap<String, Integer> occurrences = new HashMap<String, Integer>();
		for(String j : wordList)
		{
			if (occurrences.containsKey(j))
			{
				occurrences.put(j, occurrences.get(j) + 1);
			} else {
				occurrences.put(j, 1);
			}
		}
		
		return sortByValue(occurrences);
	}
	 /*
	  * Sorts HashTable in descending value order
	  */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, Integer> sortByValue(HashMap<String, Integer> map) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			 public int compare(Object o1, Object o2) {
			      return -((Comparable) ((Map.Entry) (o1)).getValue())
			     .compareTo(((Map.Entry) (o2)).getValue());
			 }
		});

	   Map result = new LinkedHashMap();
	   for (Iterator it = list.iterator(); it.hasNext();) {
	       Map.Entry entry = (Map.Entry)it.next();
	       result.put(entry.getKey(), entry.getValue());
	   }

	   return result;
	} 

}
