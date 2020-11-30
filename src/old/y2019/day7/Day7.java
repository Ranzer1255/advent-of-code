package y2019.day7;

import y2019.common.IntcodeComputer;

import java.io.File;
import java.io.FileNotFoundException;

public class Day7 {
	public static void main(String[] args) throws FileNotFoundException {
		File acs = new File("./src/y2019/day9/input.txt");

		IntcodeComputer ampA = new IntcodeComputer(acs);
		IntcodeComputer ampB = new IntcodeComputer(acs);
		IntcodeComputer ampC = new IntcodeComputer(acs);
		IntcodeComputer ampD = new IntcodeComputer(acs);
		IntcodeComputer ampE = new IntcodeComputer(acs);

		ampA.run();

	}
}
