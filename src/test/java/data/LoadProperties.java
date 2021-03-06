package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class LoadProperties 
{ 
	// Load the properties file from the data
	
	public static Properties userdata= LoadProperties(System.getProperty("user.dir")+"\\src\\test\\java\\data\\userdata.properties");
	
	private static Properties LoadProperties(String path) 
	{
		Properties pro = new Properties();
		// stream for reading file
		try {
			FileInputStream stream = new FileInputStream(path);
		try {
			pro.load(stream);
		} catch (IOException e) {
			System.out.println("Error occured:  "+ e.getMessage());
		}	
		} catch (FileNotFoundException e) {
			System.out.println("Error occured:  "+ e.getMessage());
		}
		return pro;
	}
	

}
