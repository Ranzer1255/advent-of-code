package net.ranzer.aoc.y2021.day06;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day06 extends Day {

	List<Integer> fish;

	public Day06(){
		reset();
	}

	@Override
	public void part1() {

		for (int i = 0; i < 80; i++) {
			fish = fish.stream().map(integer -> integer - 1).collect(Collectors.toList());
//			System.out.printf("Day %d: %s\n",i+1,printFish(fish));

			long count = fish.stream().filter(integer -> integer==0).count();
			fish = fish.stream().map(integer -> {
				if (integer==0){
					return 6;
				} else return integer;
			}).collect(Collectors.toList());

			for (int j = 0; j < count; j++) {
				fish.add(8);
			}
		}

		System.out.println(fish.size());
	}

	@Override
	public void part2() {
		reset();

	}

	public void reset(){
		fish  = new ArrayList<>();
		Scanner input = Input.getTestScanner(2021,6);
		input.useDelimiter(",");
		while (input.hasNext()){
			fish.add(input.nextInt());
		}
//		System.out.println(fish.size());
	}

	private String printFish(List<Integer> fish){
		StringBuilder rtn = new StringBuilder();

		fish.forEach(integer -> rtn.append(integer).append(","));

		return rtn.toString();
	}
}
