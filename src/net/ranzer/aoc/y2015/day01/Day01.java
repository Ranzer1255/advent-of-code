package net.ranzer.aoc.y2015.day01;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

public class Day01 extends Day {

	private String instructions;

	public Day01() {
		inputScanner = Input.getScanner(2015,1);
		instructions = inputScanner.nextLine();
	}

	@Override
	public void part1() {
		int floor = 0;
		for (int i = 0; i < instructions.length(); i++) {
			char nextChar = instructions.charAt(i);
			if (nextChar == '('){
				floor++;
			} else if (nextChar == ')'){
				floor--;
			}
		}

		System.out.println(floor);
	}

	@Override
	public void part2() {
		int floor = 0;
		int pos;
		for (pos = 1; pos <= instructions.length(); pos++) {
			char nextChar = instructions.charAt(pos-1);
			if (nextChar == '('){
				floor++;
			} else if (nextChar == ')'){
				floor--;
			}
			if (floor<0){
				break;
			}
		}
		System.out.println(pos);
	}
}
