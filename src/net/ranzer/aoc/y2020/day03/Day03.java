package net.ranzer.aoc.y2020.day03;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.List;

public class Day03 extends Day {

	List<List<Character>> slopes= new ArrayList<>();
	public Day03() {
		inputScanner = Input.getScanner(2020,3);

		while(inputScanner.hasNext()){
			String parse = inputScanner.nextLine();
			ArrayList<Character> line = new ArrayList<>();
			for (int i = 0; i < parse.length(); i++) {
				line.add(parse.charAt(i));
			}
			slopes.add(line);
		}
		
	}

	@Override
	public void part1() {

		System.out.println("part 1: " + checkSlope(1,3));

	}

	@Override
	public void part2() {

		long[] slopes = new long[5];

		slopes[0] = checkSlope(1,1);
		slopes[1] = checkSlope(1,3);
		slopes[2] = checkSlope(1,5);
		slopes[3] = checkSlope(1,7);
		slopes[4] = checkSlope(2,1);

		long product = 1;

		for (int i = 0; i < slopes.length; i++) {
			System.out.println(String.format("slope %d: %d",i,slopes[i]));
			product *= slopes[i];
		}

		System.out.println("part 2: "+product);


	}

	private int checkSlope(int rise, int run){
		int trees = 0;
		int running=0;
		for (int i = 0; i < slopes.size(); i+=rise) {
			if(slopes.get(i).get(running)=='#') trees++;
			running = (running + run)%slopes.get(i).size();
		}

		return trees;
	}
}
