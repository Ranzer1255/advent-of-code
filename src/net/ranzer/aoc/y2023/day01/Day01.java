package net.ranzer.aoc.y2023.day01;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day01 extends Day {

	public Day01(){

	}
	@Override
	public void part1() {
		inputScanner = Input.getScanner(2023,1);
		int total = 0;
		while (inputScanner.hasNext()){
			String line = inputScanner.nextLine();

			System.out.println(line);
			total += getnumber(line);
		}
		System.out.println(total);
	}

	private int getnumber(String line){
		StringBuilder numbers = new StringBuilder();
		for (int i = 0; i < line.length(); i++) {
			if(Character.isDigit(line.charAt(i))){
				numbers.append(line.charAt(i));
			}
		}
//		if (numbers.length()==1) return Integer.parseInt(numbers.toString());
		return Integer.parseInt(numbers.charAt(0)+""+numbers.charAt(numbers.length()-1));
	}

	@Override
	public void part2() {
		Pattern numbers = Pattern.compile(
				"\\d|oneight|eightwo|threeight|eighthree|sevenine|twone|zerone|fiveight|nineight|" +
				          "one|two|three|four|five|six|seven|eight|nine|zero");
		inputScanner = Input.getScanner(2023,1);

		int total = 0;
		while (inputScanner.hasNext()){
			String line = inputScanner.nextLine();
			List<Integer> numarray = new ArrayList<>();
			Matcher m = numbers.matcher(line);
			while (m.find()){
				numarray.addAll(getdigit(m.group()));
			}
			System.out.println(line);
			System.out.println(numarray.toString());
			System.out.println(numarray.get(0)+""+numarray.get(numarray.size()-1));
			total += Integer.parseInt(numarray.get(0)+""+numarray.get(numarray.size()-1));
		}
		System.out.println(total);

	}

	private List<Integer> getdigit(String number){
		switch (number){
			case "one":
				return Collections.singletonList(1);
			case "two":
				return Collections.singletonList(2);
			case "three":
				return Collections.singletonList(3);
			case "four":
				return Collections.singletonList(4);
			case "five":
				return Collections.singletonList(5);
			case "six":
				return Collections.singletonList(6);
			case "seven":
				return Collections.singletonList(7);
			case "eight":
				return Collections.singletonList(8);
			case "nine":
				return Collections.singletonList(9);
			case "zero":
				return Collections.singletonList(0);
			case "oneight":
				return Arrays.asList(1,8);
			case "eightwo":
				return Arrays.asList(8,2);
			case "threeight":
				return Arrays.asList(3,8);
			case "eighthree":
				return Arrays.asList(8,3);
			case "sevenine":
				return Arrays.asList(7,9);
			case"twone":
				return Arrays.asList(2,1);
			case "zerone":
				return Arrays.asList(0,1);
			case "fiveight":
				return  Arrays.asList(5,8);
			case "nineight":
				return  Arrays.asList(9,8);
			default:
				return Collections.singletonList(Integer.parseInt(number));
		}
	}
}