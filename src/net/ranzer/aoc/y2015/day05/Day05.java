package net.ranzer.aoc.y2015.day05;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day05 extends Day {

	List<String> list = new ArrayList<>();
	List<String> banned = Arrays.asList("ab","cd","pq","xy");

		public Day05(){
		input = Input.getScanner(2015,5);
		while (input.hasNext()) list.add(input.nextLine());
	}

	@Override
	public void part1() {

		List<String> p1list = new ArrayList<>(list);

		//filter banned strings
		p1list.removeIf(s -> {
			for (String b : banned){
				if (s.contains(b)) {
					System.out.println(s);
					return true;
				}
			}
			return false;
		});

		// filter 3 vowels
		p1list = p1list.stream().filter(s -> {
			int[] letters = new int[26];
			for (int i = 0; i < s.length(); i++) {
				letters[s.charAt(i)-'a']++;
			}
			int sum = 0;
			//noinspection PointlessArithmeticExpression
			sum += letters['a'-'a'];
			sum += letters['e'-'a'];
			sum += letters['i'-'a'];
			sum += letters['o'-'a'];
			sum += letters['u'-'a'];

			return sum>=3;
		}).collect(Collectors.toList());

		//filter double letters
		p1list = p1list.stream().filter(s -> {
			for (int i = 1; i < s.length(); i++) {
				if(s.charAt(i)==s.charAt(i-1))return true;
			}
			return false;
		}).collect(Collectors.toList());

		//return count
		System.out.print("count: ");
		System.out.println(p1list.size());
	}

	@Override
	public void part2() {
		List<String> p2list = new ArrayList<>(list);


		p2list = p2list.stream().filter(Day05::nicePart2
		).collect(Collectors.toList());

		p2list.forEach(System.out::println);
		//output
		System.out.println(p2list.size());
	}

	private static boolean nicePart2(String string) {
		Pattern letterPairs = Pattern.compile("(.{2}).*\\1");
		Pattern letterSamich = Pattern.compile("(.).\\1");
		Matcher pair = letterPairs.matcher(string);
		Matcher samich = letterSamich.matcher(string);
		return (pair.find()&&samich.find());
	}
}
