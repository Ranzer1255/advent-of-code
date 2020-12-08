package net.ranzer.aoc.y2020.day07;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day07 extends Day {

	Pattern containerPattern = Pattern.compile("^(?<bag>[a-z]+\\s[a-z]+)\\sbags?");
	Pattern contentsPattern = Pattern.compile("(?<no>\\d+) (?<bag>[a-z]+\\s[a-z]+)\\sbags?");
	Map<String, Bag> bagTypes = new HashMap<>();

	public Day07() {

		inputScanner = Input.getScanner(2020,7);

		while (inputScanner.hasNext()){
			String line = inputScanner.nextLine();
			Matcher matcherContainer = containerPattern.matcher(line);
			Matcher matcherContents = contentsPattern.matcher(line);

			matcherContainer.find();
			String containerString = matcherContainer.group("bag");
			Bag container = bagTypes.get(containerString);
			if (container==null) {
				container = new Bag(matcherContainer.group("bag"));
				bagTypes.put(matcherContainer.group("bag"),container);
			}

			while (matcherContents.find()){
				String contentString = matcherContents.group("bag");
				Bag contents = bagTypes.get(contentString);
				if (contents==null) {
					contents = new Bag(contentString);
					bagTypes.put(contentString,contents);
				}
				container.addBag(contents,Integer.parseInt(matcherContents.group("no")));
			}
		}

	}

	@Override
	public void part1() {

		System.out.println(bagTypes.get("shiny gold").allOuterBags().size());

	}

	@Override
	public void part2() {

		System.out.println(bagTypes.get("shiny gold").innerBagCount());
	}

}
