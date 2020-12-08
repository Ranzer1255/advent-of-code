package net.ranzer.aoc.y2020.day08;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day08 extends Day {

	List<String> instructions = new ArrayList<>();

	public Day08() {
		inputScanner = Input.getScanner(2020,8);
		while (inputScanner.hasNext()){
			instructions.add(inputScanner.nextLine());
		}
		inputScanner.close();
	}

	@Override
	public void part1() {
		Set<Integer> previousInstructions=new HashSet<>();
		int previousCounter;
		int counter = 0;
		int acc=0;
		while (true) {
			previousCounter=counter;
			String instruction = instructions.get(counter);
			String op = instruction.substring(0,3);
			switch (op) {
				case "nop":
					counter++;
					break;
				case "acc":
					counter++;
					acc += Integer.parseInt(instruction.substring(4));
					break;
				case "jmp":
					counter += Integer.parseInt(instruction.substring(4));
					break;
				default:
					System.out.println("um WAT?!");
					System.exit(-1);
			}
			if(!previousInstructions.add(counter)){
				break;
			}
		}
		System.out.println(acc);
	}

	@Override
	public void part2() {

	}
}
