package hust.soict.khmt.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class GarbageCreator {
	public static void main(String[] args) {
		
		
		File f;
		try {
			f = new File("./src/hust/soict/khmt/garbage/trash.txt");
			Scanner fileReader = new Scanner(f);
			System.out.println(fileReader.nextLine());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		
		
		
	}
}
