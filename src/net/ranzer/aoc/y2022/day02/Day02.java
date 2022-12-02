package net.ranzer.aoc.y2022.day02;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

public class Day02 extends Day {

	public Day02(){



	}
	@Override
	public void part1() {
		inputScanner = Input.getScanner(2022,2);
		int Score = 0;
		while (inputScanner.hasNext()){
			Throw theirMove = Throw.decode(inputScanner.next());
			Throw yourMove = Throw.decode(inputScanner.next());
			Score += yourMove.VALUE + yourMove.vs(theirMove);
		}
		System.out.println(Score);


	}

	@Override
	public void part2() {
		inputScanner = Input.getScanner(2022,2);
		int Score = 0;
		while (inputScanner.hasNext()){
			Throw theirMove = Throw.decode(inputScanner.next());
			Score += theirMove.strat(inputScanner.next());
		}
		System.out.println(Score);

	}

	private enum Throw{
		ROCK(1), PAPER(2), SCISSORS(3);

		int VALUE;

		Throw(int value){
			this.VALUE=value;
		}

		int strat(String plan){
			switch (plan){
				case "X": //Lose
					switch (this){
						case ROCK:
							return SCISSORS.VALUE;
						case PAPER:
							return ROCK.VALUE;
						case SCISSORS:
							return PAPER.VALUE;
					}
				case "Y": //draw
					switch (this){
						case ROCK:
							return 3 + ROCK.VALUE;
						case PAPER:
							return 3 + PAPER.VALUE;
						case SCISSORS:
							return 3 + SCISSORS.VALUE;
					}
				case "Z":
					switch (this){
						case ROCK:
							return 6 + PAPER.VALUE;
						case PAPER:
							return 6 + SCISSORS.VALUE;
						case SCISSORS:
							return 6 + ROCK.VALUE;
					}
				default: return -1;
			}
		}

		int vs(Throw vs){
			switch (this){
				case ROCK:
					switch (vs){
						case ROCK:
							return 3;
						case PAPER:
							return 0;
						case SCISSORS:
							return 6;
					}
				case PAPER:
					switch (vs){
						case ROCK:
							return 6;
						case PAPER:
							return 3;
						case SCISSORS:
							return 0;
					}
				case SCISSORS:
					switch (vs){
						case ROCK:
							return 0;
						case PAPER:
							return 6;
						case SCISSORS:
							return 3;
					}
				default: return -1;
			}
		}

		static Throw decode(String letter){
			switch (letter){
				case "A":
				case "X":
					return ROCK;
				case "B":
				case "Y":
					return PAPER;
				case "C":
				case "Z":
					return SCISSORS;
				default:
					throw new IllegalArgumentException("must be A, B, C, X, Y, or Z");
			}
		}
	}


}
