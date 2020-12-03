package y2019.day5;

import y2019.common.IntcodeComputer;

import java.io.FileNotFoundException;

public class Day5 {
	public static void main(String[] args) throws FileNotFoundException {

		IntcodeComputer ic = new IntcodeComputer();
		ic.setProgram("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2019/day5/input");


		ic.run();

	}
}
