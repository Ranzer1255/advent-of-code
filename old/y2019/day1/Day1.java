package y2019.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Day1 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2019/day1/input.txt"));

		Stack<Integer> moduleMasses = new Stack<>();
		while  (input.hasNextInt()){
			moduleMasses.push(input.nextInt());
		}

//		moduleMasses.push(1969);

		int totalFuel = 0;
		while (!moduleMasses.empty()){
			int i = moduleMasses.pop();
			int moduelFuel = (i/3)-2;
			if (moduelFuel>0){
				totalFuel += moduelFuel;
				moduleMasses.push(moduelFuel);
			}
		}
		System.out.println(totalFuel);
	}
}
