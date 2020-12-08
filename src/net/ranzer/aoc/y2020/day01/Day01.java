package net.ranzer.aoc.y2020.day01;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.List;

public class Day01 extends Day {

	List<Integer> expenses = new ArrayList<>();

	public Day01(){
		inputScanner = Input.getScanner(2020,1);

		while (inputScanner.hasNext()){
			expenses.add(inputScanner.nextInt());
		}
	}


	@Override
	public void part1() {

		for (int i = 0; i < expenses.size(); i++) {
			for (int j = i+1; j < expenses.size(); j++) {
				if(expenses.get(i) + expenses.get(j) ==2020){
					System.out.println(expenses.get(i)*expenses.get(j));
					break;
				}
			}
		}

	}

	@Override
	public void part2() {

		for (int i = 0; i < expenses.size(); i++) {
			for (int j = i+1; j < expenses.size(); j++) {
				for (int k = j+1; k < expenses.size(); k++) {
					if(expenses.get(i) + expenses.get(j)+ expenses.get(k) ==2020){
						System.out.println(expenses.get(i)*expenses.get(j)*expenses.get(k));
						break;
					}
				}
			}
		}

	}
}
