package y2017.day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5 {
	
	static File day5input = new File("C:/Users/jrdillingham.MABANKISD/Programing/workspace/adventofcode/src/day05/day5input");
	static List<Integer> jumps = new ArrayList<>();	
	
	public static void main(String[] args) {

		//build array
		try(Scanner read = new Scanner(day5input)){
			
			while(read.hasNextLine()){
				jumps.add(Integer.parseInt(read.nextLine()));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("part 1: "+numOfJumpsPart1());
		System.out.println("part 2: "+numOfJumpsPart2());
		
	}

	private static int numOfJumpsPart2() {
		int[] list = new int[jumps.size()];
		for (int i = 0; i < list.length; i++) {
			list[i]=jumps.get(i).intValue();
		}
		
		int index = 0;
		int count = 0;
		while(index>=0&&index<list.length){
			boolean subtract=false;
			if(list[index]>=3) subtract = true;
			int newIndex=index+list[index];
			if(subtract){
				list[index]--;
			} else {
				list[index]++;
			}
			index=newIndex;
			count++;
		}
		return count;
	}

	private static int numOfJumpsPart1() {
		int[] list = new int[jumps.size()];
		for (int i = 0; i < list.length; i++) {
			list[i]=jumps.get(i).intValue();
		}
		
		int index = 0;
		int count = 0;
		while(index>=0&&index<list.length){
			index+=list[index]++;
			count++;
		}
		return count;
	}

}
