package y2019.day9;

import y2019.common.IntcodeComputer;

import java.io.File;
import java.io.FileNotFoundException;

public class Day9 {
	public static void main(String[] args) throws FileNotFoundException {
		IntcodeComputer ic = new IntcodeComputer(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2019/day9/input"));


		ic.run();

	}
}
