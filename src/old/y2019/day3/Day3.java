package y2019.day3;

import y2019.common.IntcodeComputer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
	public static void main(String[] args) throws FileNotFoundException {

		File program = new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2019/day3/input.txt");
		IntcodeComputer ic = new IntcodeComputer(program);

		ic.run();
	}
}
