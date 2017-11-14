package cse360groupproject;

import java.util.ArrayList;
import java.util.Map;

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
		this.avgCharLine = 0;
		this.avgWordLen = 0;
		this.wordOccurrence = null;
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

}
