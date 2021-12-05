package net.ranzer.aoc.y2021.day04;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.Scanner;

public class Day04 extends Day {

	ArrayList<Integer> moves;
	ArrayList<BingoBoard> boards;


	public Day04(){

		reset();

	}

	@Override
	public void part1() {

		loop:for (Integer v: moves){
			for (BingoBoard b: boards){
				if (b.mark(v)) {
					System.out.println(b.score());
					break loop;
				}
			}
		}

	}

	@Override
	public void part2() {

	}

	public void reset(){
		Scanner input = Input.getTestScanner(2021,4);
		moves = new ArrayList<>();
		boards = new ArrayList<>();

		String numbers = input.nextLine();

		Scanner moveParser = new Scanner(numbers).useDelimiter(",");
		while (moveParser.hasNext()){
			moves.add(moveParser.nextInt());
		}

		while(input.hasNext()){
			ArrayList<Integer> boardValues = new ArrayList<>();
			input.nextLine();
			for (int i = 0; i < 25; i++) {
				boardValues.add(input.nextInt());
			}
			boards.add(new BingoBoard(boardValues));
		}
	}
}
