package net.ranzer.aoc.y2019.day01;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.List;

public class Day01 extends Day {

	List<Integer> parts = new ArrayList<>();

	public Day01() {
		inputScanner = Input.getScanner(2019,1);
		while (inputScanner.hasNext()){
			parts.add(Integer.parseInt(inputScanner.nextLine()));
		}
	}

	@Override
	public void part1() {

		int sum = 0;

		for (int mass:parts){
			sum+= (mass/3)-2;
		}

		System.out.println(sum);

	}

	@Override
	public void part2() {

		//make a copy of the the list to preserve initialized state (in case part one is run *after* part 2)
		List<Integer> fuelCalcs = new ArrayList<>(parts);

		int fuelTotal = 0;
		for (int i = 0; i < fuelCalcs.size(); i++) {
			int fuel = (fuelCalcs.get(i)/3)-2;
			if (fuel>0){
				fuelTotal += fuel;
				fuelCalcs.add(fuel);
			}
		}

		System.out.println(fuelTotal);
	}
}
