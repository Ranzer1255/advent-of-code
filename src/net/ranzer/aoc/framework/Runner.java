package net.ranzer.aoc.framework;

import net.ranzer.aoc.y2020.day05.Day05;
import net.ranzer.aoc.y2020.day06.Day06;

import java.util.Date;

public class Runner {

	public static void main(String[] args) {

		Date startTime = new Date();
		Day testDay = new Day06();



		testDay.part1();
		testDay.part2();


		Date endTime = new Date();

		System.out.println("time: " + (endTime.getTime() - startTime.getTime()));
	}
}
