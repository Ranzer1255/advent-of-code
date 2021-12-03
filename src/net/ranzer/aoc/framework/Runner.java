package net.ranzer.aoc.framework;

import net.ranzer.aoc.y2021.day03.Day03;

import java.util.Date;

public class Runner {

	public static void main(String[] args) {

		Date startTime = new Date();
		Day testDay = new Day03();



		testDay.part1();
		testDay.part2();


		Date endTime = new Date();

		System.out.println("time: " + (endTime.getTime() - startTime.getTime()));
	}
}
