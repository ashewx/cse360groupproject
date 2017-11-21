package cse360groupproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AllFiles {

	private int avgNumLine;
	private int avgNumBlank;
	private int avgNumSpaces;
	private int avgCharLine;
	private int avgWordLen;
	private Map<String, Integer> wordOccurrence;
	
	public AllFiles(ArrayList<TextFile> history) {
		this.avgNumLine = 0;
		this.avgNumBlank = 0;
		this.avgNumSpaces = 0;
		this.avgCharLine = calcAvgChar(history);
		this.avgWordLen = calcWordLen(history);
		this.wordOccurrence = calcWordOccurence(history);
	}

	public int getAvgNumLine() {
		return avgNumLine;
	}

	public int getAvgNumBlank() {
		return avgNumBlank;
	}

	public int getAvgNumSpaces() {
		return avgNumSpaces;
	}

	public int getAvgCharLine() {
		return avgCharLine;
	}

	public int getAvgWordLen() {
		return avgWordLen;
	}

	public Map<String, Integer> getWordOccurrence() {
		return wordOccurrence;
	}
	
	public int calcAvgChar(ArrayList<TextFile> files) {
		int totalLine = 0;
		int totalChar = 0;
		for(int i = 0; i < files.size(); i++) {
			totalLine += files.get(i).getNumLines();
			totalChar += files.get(i).getInput().length() - files.get(i).getNumSpaces();
		}
		return totalChar/totalLine;
	}
	
	public int calcWordLen(ArrayList<TextFile> files) {
		int totalWord = 0;
		int totalChar = 0;
		for(int i = 0; i < files.size(); i++) {
			String[] wordList = files.get(i).getInput().split("\\W+");
			for(String j : wordList)
			{
				totalChar += j.length();
			}
			totalWord += wordList.length;
		}
		int average = (int)(totalChar/totalWord);
		return average;
	}
	
	public Map<String, Integer> calcWordOccurence(ArrayList<TextFile> files) {
		HashMap<String, Integer> newOccurence = new HashMap<String, Integer>();
		for (int i = 0; i < files.size(); i++) {
			for (Entry<String, Integer> pair : files.get(i).getWordOccurrence().entrySet()){
	            //iterate over the pairs
				if(newOccurence.containsKey(pair.getKey())) {
					newOccurence.put(pair.getKey(), newOccurence.get(pair.getKey()) + pair.getValue());
				} else {
					newOccurence.put(pair.getKey(), pair.getValue());
				}
	        }
		}
		return sortByValue(newOccurence);
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
