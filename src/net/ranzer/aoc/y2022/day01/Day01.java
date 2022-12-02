package net.ranzer.aoc.y2022.day01;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day01 extends Day {

	List<List<Integer>> elves;

	public Day01(){
		inputScanner = Input.getScanner(2022,1);

		int index = 0;
		elves = new ArrayList<>();
		elves.add(new ArrayList<>());
		while (inputScanner.hasNext()){
			String line = inputScanner.nextLine();
			if(line.isEmpty()){
				elves.add(new ArrayList<>());
				index++;
			} else {
				elves.get(index).add(Integer.parseInt(line));
			}

		}
//		testDataStructure(elves);
	}

	private void testDataStructure(List<List<Integer>> elves) {

		for (List<Integer> elf : elves) {
			for (Integer cal: elf) {
				System.out.println(cal);

			}
			System.out.println();
		}

	}

	@Override
	public void part1() {
		int largestSum = Integer.MIN_VALUE;
		for(List<Integer> elf: elves){
			int sum = elf.stream().reduce(0,Integer::sum);
			if (sum > largestSum) largestSum = sum;
		}
		System.out.println(largestSum);
	}

	@Override
	public void part2() {
		List<Integer> elfSums = new ArrayList<>();
		elves.forEach(elf -> {
			elfSums.add(elf.stream().reduce(0,Integer::sum));
		});

		System.out.println(elfSums.stream().sorted(Comparator.reverseOrder()).limit(3).reduce(0,Integer::sum));
	}
}
