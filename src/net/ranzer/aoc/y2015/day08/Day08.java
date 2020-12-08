package net.ranzer.aoc.y2015.day08;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.List;

public class Day08 extends Day {

	List<String> rawStrings = new ArrayList<>();
	List<String> encodedStrings;

	public Day08() {
		inputScanner = Input.getTestScanner(2015,8);
		while (inputScanner.hasNext()){
			rawStrings.add(inputScanner.nextLine());
		}

		encodedStrings = encode(rawStrings);
	}

	private List<String> encode(List<String> rawStrings) {
		List<String> rtn = new ArrayList<>();



		return rtn;
	}

	@Override
	public void part1() {

	}

	@Override
	public void part2() {

	}
}
