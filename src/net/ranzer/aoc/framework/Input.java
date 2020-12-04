package net.ranzer.aoc.framework;

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

	public static Scanner getTestScanner(int year, int day) {
		try {
			return new Scanner(getTestFile(year,day));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

	public static File getFile(int year,int day){
		return new File(getPath(year,day));
	}

	public static File getTestFile(int year,int day){
		return new File(getTestPath(year,day));
	}

	public static String getPath(int year, int day) {
		return String.format("./src/net/ranzer/aoc/y%d/day%02d/input",year,day);
	}

	public static String getTestPath(int year, int day) {
		return String.format("./src/net/ranzer/aoc/y%d/day%02d/testInput",year,day);
	}


}
