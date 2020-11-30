package y2017.day02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DayTwo {

	static String inputPath = "C:/Users/sgman/programing/java/workspace/adventOfCode2017/src/dayTwo/dayTwoInput.txt";
	static ArrayList<ArrayList<String>> table;
	
	public static void main(String[] args){

		

		table = parseTable();
		
		

		System.out.println(partOne());
		System.out.println(partTwo());
		
		

//		printTable();
	}

	private static String partTwo() {
		int checksum = 0;
		
		for (ArrayList<String> row : table) {
			int numerator=0,denominator=0;
			a: for (int i = 0; i < row.size(); i++) {
				int numI = Integer.parseInt(row.get(i));
				for (int j = i+1; j < row.size(); j++) {
					int numJ = Integer.parseInt(row.get(j));
					if(numI%numJ==0){
						// i/j
						numerator = numI;
						denominator = numJ;
						break a;
					} else if (numJ%numI==0){
						// j/i
						numerator = numJ;
						denominator = numI;
						break a;
					}
				}
			}
			checksum+=(numerator/denominator);
		}
		
		return "Day 2 part 2: "+checksum;
	}

	private static String partOne() {
		int totalSum=0;
		for (ArrayList<String> row : table) {
			int rowValue =0, rowLow=Integer.MAX_VALUE, rowHi=Integer.MIN_VALUE; 
			for (String entry : row) {
				int ent= Integer.parseInt(entry);
				if (ent>rowHi) rowHi=ent;
				if (ent<rowLow) rowLow=ent;
			}
			rowValue = rowHi-rowLow;
			totalSum += rowValue;
		}
		
		return "Day 2 part 1: " + totalSum;
	}

	private static ArrayList<ArrayList<String>> parseTable() {
		try {
			ArrayList<ArrayList<String>> rtn = new ArrayList<>();
			Scanner read = new Scanner(new File(inputPath));
			int i = 0;
			while (read.hasNextLine()) {
				rtn.add(new ArrayList<>());
				String temp = read.nextLine();
				String[] nums = temp.split("\\s");
				rtn.get(i).addAll(Arrays.asList(nums));
				i++;
			}
			read.close();
			return rtn;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

	public static void printTable(){
		for (ArrayList<String> row : table) {
			for (String string : row) {
				System.out.print(string+" ");
			}
			System.out.println();
		}
	}
}
