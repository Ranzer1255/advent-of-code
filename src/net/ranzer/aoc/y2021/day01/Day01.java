package net.ranzer.aoc.y2021.day01;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;

public class Day01 extends Day {

	ArrayList<Integer> depths = new ArrayList<>();

	public Day01(){
		inputScanner = Input.getScanner(2021,1);
		while (inputScanner.hasNext()){
			depths.add(inputScanner.nextInt());
		}
	}

	@Override
	public void part1() {
		int increased = 0;
		int previous = -1;
		for(Integer i: depths){
			if (i > previous && previous>0){
				increased++;
			}
			previous = i;
		}
		System.out.println("the depth has increased " + increased + " times.");
	}

	@Override
	public void part2() {

		int increased = 0;
		int previous = -1;
		for(int i = 0; i<depths.size()-2;i++){
			int depth = depths.get(i)+depths.get(i+1)+depths.get(i+2);

			if (depth > previous && previous>0){
				increased++;
			}
			previous = depth;
		}
		System.out.println("the depth has increased " + increased + " times.");
	}
}
