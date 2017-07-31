import java.io.*;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//Logic for Question3
public class PrintDictionary {

	static String filePath;
	public static boolean doesFileExist(String filePath) 
	// This function returns true if the file exists otherwise returns false
	{
		PrintDictionary.filePath = filePath;
		filePath = System.getProperty("user.dir") + filePath;
		File fileName = new File(filePath);

		if (fileName.exists()) {
			//System.out.println("Function:File found");
			return true;
		} else {
			//System.out.println("Function:File not found");
			return false;
		}
	}

	public static void main(String[] args) throws IOException,org.json.simple.parser.ParseException 
	{		
		try {
			String fileName = "\\dictionary.txt";
			//This is the file name. It is just hard coded to show the functionality
			if (doesFileExist(fileName) == false) 
			//if file not found then display error and don't proceed further
			{
				System.out.println("File or directory not found");				
			} 
			else 
			//else case file found, proceed with the process
			{
				fileName = System.getProperty("user.dir") + fileName;
				//System.out.println("main file path:" + fileName);
				JSONParser parser = new JSONParser();

				Object obj = parser.parse(new FileReader(fileName));

				JSONObject jsonObject = (JSONObject) obj;

				// Displays as Key,Value pair
				Set<?> keys = jsonObject.keySet();

				Iterator<?> itr = keys.iterator();
				do {
					String key = itr.next().toString();
					System.out.println(key);

					JSONArray valuePair = (JSONArray) jsonObject.get(key);

					@SuppressWarnings("unchecked")
					Iterator<String> iterator = valuePair.iterator();
					while (iterator.hasNext()) {
						System.out.println(iterator.next());
					}
				} while (itr.hasNext());
			}
		} catch (Exception e) {
			// we can print the customized error messages, if required.
			e.printStackTrace();
		}
	}
}
