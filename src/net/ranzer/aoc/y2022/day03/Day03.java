package net.ranzer.aoc.y2022.day03;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day03 extends Day {

	public Day03(){
		inputScanner = Input.getScanner(2022,3);
	}
	@Override
	public void part1() {

		int sum = 0;
		outer:while (inputScanner.hasNextLine()){
			String sack = inputScanner.nextLine();

			String leftPouch = sack.substring(0,sack.length()/2);
			String rightPouch = sack.substring(sack.length()/2);

			System.out.println(leftPouch);
			System.out.println(rightPouch);

			Set<Character> types = new HashSet<>();
			for (int i = 0; i < leftPouch.length(); i++) {
				types.add(leftPouch.charAt(i));
			}

			for (int i = 0; i < rightPouch.length(); i++) {
				if (types.contains(rightPouch.charAt(i))){
					System.out.print(rightPouch.charAt(i) + " " + convertToScore(rightPouch.charAt(i))+ "\n");
					sum+=convertToScore(rightPouch.charAt(i));
					continue outer;
				}
			}
		}
		System.out.println(sum);
	}

	@Override
	public void part2() {

		inputScanner = Input.getTestScanner(2022,3);



	}

	private int convertToScore(char letter){

		if (letter>='a'){
			return letter-'`';
		}

		return letter-'A'+1+26;
	}
}
