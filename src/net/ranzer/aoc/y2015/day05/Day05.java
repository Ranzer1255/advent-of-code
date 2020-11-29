package net.ranzer.aoc.y2015.day05;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day05 extends Day {

	List<String> list = new ArrayList<>();
	List<String> banned = Arrays.asList("ab","cd","pq","xy");

	public Day05(){
		input = Input.getScanner(2015,5);
		while (input.hasNext()) list.add(input.nextLine());
	}

	@Override
	public void part1() {

		list.removeIf(s -> {
			for (String b : banned){
				if (s.contains(b)) return true;
			}
			return false;
		});
	}

	@Override
	public void part2() {

	}
}
