package y2015.day03;

import framework.Day;
import framework.Input;
import framework.common.Loc;

import java.util.HashSet;
import java.util.Set;

public class Day03 extends Day {
	final String instructions;


	public Day03(){
		examples.add("^v^v^v^v^v");
		examples.add("^>v<");
		input = Input.getScanner(2015,3);
		instructions = input.nextLine();
//		instructions = examples.get(1);
	}

	@Override
	public void part1() {
		Set<Loc> houses = new HashSet<>();

		Loc pos = new Loc(0,0);
		houses.add(pos);

		for (int i = 0; i < instructions.length(); i++) {
			char move = instructions.charAt(i);
			pos = move(pos,move);
			houses.add(pos);
		}

		System.out.println(houses.size());
	}

	@Override
	public void part2() {
		Set<Loc> houses = new HashSet<>();

		Loc santaPos = new Loc(0,0);
		Loc roboPos = new Loc(0,0);
		houses.add(santaPos);
		houses.add(roboPos);

		for (int i = 0; i < instructions.length(); i+=2) {
			char sMove = instructions.charAt(i);
			char rMove = instructions.charAt(i+1);

			//move santa and add the house if new
			santaPos = move(santaPos,sMove);
			houses.add(santaPos);

			//move robosanta and add the house if new
			roboPos = move(roboPos,rMove);
			houses.add(roboPos);

		}

		System.out.println(houses.size());

	}

	private Loc move(Loc pos, char move) {
		Loc rtn = null;
		switch (move){
			case '<':
				rtn = pos.left();
				break;
			case '>':
				rtn = pos.right();
				break;
			case '^':
				rtn = pos.up();
				break;
			case 'v':
				rtn = pos.down();
				break;
		}
		return rtn;
	}
}
