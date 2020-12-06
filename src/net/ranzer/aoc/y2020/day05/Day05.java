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
			for (int i = 0; i < line.length(); i++) {
				id = id << 1;
				if (line.charAt(i) == 'B'||line.charAt(i)=='R') id++;
			}
			seatIDs.add(id);
		}

	}

	@Override
	public void part1() {
		System.out.println(seatIDs.stream().max(Integer::compareTo).get());
	}

	@Override
	public void part2() {

		seatIDs.sort(Integer::compareTo);

		seatIDs.forEach(System.out::println);

		for (int i = 1; i < seatIDs.size()-1; i++) {
			if ((seatIDs.get(i)-1)!=(seatIDs.get(i-1))) {
				System.out.println(seatIDs.get(i)-1);
				break;
			}
		}
	}
}
