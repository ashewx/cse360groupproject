package cse360groupproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFile {
	private String name;
	private String input;
	private int numLines;
	private int blankLn;
	private int numSpaces;
	private int numWords;
	private int avgCharPerLn;
	private int avgWrdLen;
	
	public TextFile(String filename, String everythingInsideFile) {
		// TODO Auto-generated constructor stub
	}
	
	
	public void LineCount(String filepath) throws FileNotFoundException
	{
		
		
		File aFile = new File("/Users/jordanlewis/Documents/workspace/FileReader/TestCases/Test_1.txt");
		Scanner freader = new Scanner(aFile);
		while (freader.hasNextLine()) 
		{
			  numLines++;
			  freader.nextLine();
		}
		numLines = numLines -7;
		System.out.println(numLines);
		
	}
	

}
