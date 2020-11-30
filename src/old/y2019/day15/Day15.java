package y2019.day15;


import java.util.*;

public class Day15 {
	private static RepairBot repairBot = new RepairBot();

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		main:while (true){

			displayMoves();
			System.out.println();
			displayCanvas(repairBot.getWorld());

			int command = in.nextInt();
			switch (command){
				case 9: //explore
					new WallFollower().explore();
					break main;
				case 5:
					break main;
				case 6:
					repairBot.backtrack(1);
					continue;
				case 1:
				case 2:
				case 3:
				case 4:
					Direction direction = Direction.get(command);
					repairBot.move(direction);
					break;
				default:
					System.out.println("i didn't understand, try again: ");
					break;
			}
		}
	}

	private static void displayCanvas(Map<Loc, State> canvas) {
		Canvas.displayCanvas(canvas);
	}

	private static void displayMoves() {
		for (Direction d :
				Direction.values()) {
			System.out.println(d.toString() +": "+ d.code);
		}
	}
}
