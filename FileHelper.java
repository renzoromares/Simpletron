/**
 * Open and read a file, and return the lines in the file as a list
 * of Strings.
 * (Demonstrates Java FileReader, BufferedReader, and Java5.)
 */
import java.io.*;
import java.util.*;

public class FileHelper{
 
	public static List<String> readFile(String filename )
	{
	  List<String> records = new ArrayList<String>();
	  try
	  {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line;
		while ((line = reader.readLine()) != null)
		{
		  records.add(line);
		}
		reader.close();
		return records;
	  }
	  catch (Exception e)
	  {
		System.err.format("Exception occurred trying to read '%s'.", filename);
		e.printStackTrace();
		return null;
	  }
	}

}