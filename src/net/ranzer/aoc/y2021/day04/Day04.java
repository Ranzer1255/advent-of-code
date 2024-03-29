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
					System.out.printf("Part 1: First win Bard score: %d\n",b.score(v));
					break loop;
				}
			}
		}

	}

	@Override
	public void part2() {
		reset();

		BingoBoard lastWinningBoard=null;
		int lastWinningMove = -1;
		for(int v: moves){
			for (BingoBoard b:boards){
				//this line fixed my issue, but i'm not sure why it's needed....
				//it *shouldn't* be processing finished boards as they are supposed to be getting removed
				if(b.isFinished()) continue;
				if (b.mark(v))	{
					lastWinningBoard = b;
					lastWinningMove = v;
					System.out.printf(
							"Boards size :%d\nwinning call: %d\nScore: %d\nBoard state:\n%s",
							boards.size(),v,b.score(v),b);
				}
			}
			if(lastWinningBoard!=null)	{
				boards.remove(lastWinningBoard);
			}
		}
		System.out.println(lastWinningBoard.score(lastWinningMove));
	}

	public void reset(){
		Scanner input = Input.getScanner(2021,4);
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
