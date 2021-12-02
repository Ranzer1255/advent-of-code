package net.ranzer.aoc.y2021.day02;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.Scanner;

public class Day02 extends Day {

	ArrayList<Sub.Command> commands = new ArrayList<>();

	public Day02(){
		Scanner input = Input.getScanner(2021,2);
//		input.useDelimiter("\n");

		while (input.hasNext()){
			commands.add(new Sub.Command(input.next(),input.nextInt()));
		}


	}

	@Override
	public void part2() {
		Sub boat = new Sub();

		for (Sub.Command c:commands){
			boat.command(c.direction,c.distance);
		}

		System.out.println(boat.x_position*boat.depth);
	}

	@Override
	public void part1() {

		//sub code isn't setup for part one anymore
	}
}
