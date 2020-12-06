package net.ranzer.aoc.y2020.day05;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.List;

public class Day05 extends Day {

	/* Conversion notes:
		F == 0,
		B == 1,
		L == 0,
		R == 1
	*/

	List<Integer> seatIDs = new ArrayList<>();

	public Day05() {

		input = Input.getScanner(2020,5);

		while (input.hasNext()) {
			int id = 0;
			String line = input.nextLine();

			//build binary one character at a time using above conversion table
			for (int i = 0; i < line.length(); i++) {

				//left shift the current number to make room for the next character
				id = id << 1;

				//if its a B or an R make the last digit a 1 in the binary
				if (line.charAt(i) == 'B'||line.charAt(i)=='R') id++;
			}
			seatIDs.add(id);
		}

	}

	@Override
	public void part1() {

		//output the highest number in the list
		System.out.println(seatIDs.stream().max(Integer::compareTo).get());
	}

	@Override
	public void part2() {

		//sort the seatIDs
		seatIDs.sort(Integer::compareTo);

//		seatIDs.forEach(System.out::println);

		//print the seat ID that's missing
		for (int i = 1; i < seatIDs.size()-1; i++) {
			if ((seatIDs.get(i)-1)!=(seatIDs.get(i-1))) {
				System.out.println(seatIDs.get(i)-1);
				break;
			}
		}
	}
}
