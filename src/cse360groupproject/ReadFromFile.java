package cse360groupproject;

import java.io.*;

public class ReadFromFile
{
	public  static void main(String[] args) throws Exception
	{
		File file = new File("C:\\Users\\bgshu\\Desktop\\test.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		while ((st = br.readLine()) != null)
		{
			System.out.println(st);
		}
	}
}
