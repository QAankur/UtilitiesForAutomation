package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVUtility {

	public static boolean verifyValueIsPresent(String value, String filepath)  
	{
		try {
			CSVReader csvdReader=new CSVReader(new FileReader(filepath));
			String line=null;
			List<String[]> list=csvdReader.readAll();
			list.get(0)[1]=value;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
	}
}
