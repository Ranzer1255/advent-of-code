package net.ranzer.aoc.y2020.day04;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04 extends Day {

	List<Passport> passports = new ArrayList<>();

	public Day04() {
		inputScanner = Input.getScanner(2020,4);

		StringBuilder passportString = new StringBuilder();
		while (inputScanner.hasNext()){
			String s = inputScanner.nextLine();
			if(s.equals("")){
				passports.add(parsePassport(passportString.toString()));
				passportString = new StringBuilder();
			} else {
				passportString.append(" ").append(s);
			}
		}

		passports.add(parsePassport(passportString.toString()));
	}

	@Override
	public void part1() {

		int count=0;
		for (Passport p: passports){
			if(p.isPartOneValid()) count++;
		}

		System.out.println(count);
	}

	@Override
	public void part2() {
		int count=0;
		for (Passport p: passports){
			if(p.isPartTwoValid()) count++;
		}

		System.out.println(count);
	}

	private Passport parsePassport(String input){
		Pattern kvPair = Pattern.compile("(?<key>\\S{3}):(?<value>\\S+)");

		Matcher m = kvPair.matcher(input);

		Passport p = new Passport();

		while(m.find()){
			p.addData(Passport.Key.getKey(m.group("key")),m.group("value"));
		}

		return p;
	}
}
