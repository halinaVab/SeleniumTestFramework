package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

	public static String readDataFromFile(String filePath) {
		File file = new File(filePath);
		BufferedReader br;
		String st;
		String data = "";
		try {
			br = new BufferedReader(new FileReader(file));
			while ((st = br.readLine()) != null) {
				data = st;
			}
		} catch (IOException e) {
			System.out.println("Failed to read data from file");
			e.printStackTrace();
		}
		return data;
	}
	
}
