package framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {

	public static Scanner getScanner(int year, int day) {
		try {
			return new Scanner(getFile(year,day));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

	public static File getFile(int year,int day){
		return new File(getPath(year,day));
	}

	public static String getPath(int year, int day) {
		return String.format("./src/y%d/day%02d/input",year,day);
	}


}
