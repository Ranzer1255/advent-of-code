package y2016.day01;

import java.util.ArrayList;
import java.util.Scanner;

import y2016.day01.Facing.Direction;

public class Directions {

	static String input = "R2, L1, R2, R1, R1, L3, R3, L5, L5, L2, L1, R4, R1, R3, L5, L5, R3, L4, L4, R5, R4, R3, L1, L2, R5, R4, L2, R1, R4, R4, L2, L1, L1, R190, R3, L4, R52, R5, R3, L5, R3, R2, R1, L5, L5, L4, R2, L3, R3, L1, L3, R5, L3, L4, R3, R77, R3, L2, R189, R4, R2, L2, R2, L1, R5, R4, R4, R2, L2, L2, L5, L1, R1, R2, L3, L4, L5, R1, L1, L2, L2, R2, L3, R3, L4, L1, L5, L4, L4, R3, R5, L2, R4, R5, R3, L2, L2, L4, L2, R2, L5, L4, R3, R1, L2, R2, R4, L1, L4, L4, L2, R2, L4, L1, L1, R4, L1, L3, L2, L2, L5, R5, R2, R5, L1, L5, R2, R4, R4, L2, R5, L5, R5, R5, L4, R2, R1, R1, R3, L3, L3, L4, L3, L2, L2, L2, R2, L1, L3, R2, R5, R5, L4, R3, L3, L4, R2, L5, R5";
	
	static Facing direction =Facing.NORTH;//starting facing
	static int x=0,y=0;
	static ArrayList<Loc> trail = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		sc.useDelimiter(", ");
		trail.add(new Loc(x,y));
		
		while (sc.hasNext()) {
			String step = sc.next();
			
			switch (step.charAt(0)){
			case 'R':
				direction = direction.turn(Direction.RIGHT);
				break;
			case 'L':
				direction = direction.turn(Direction.LEFT);
				break;
			}
			step(step.substring(1, step.length()));
			
			
		}
		
		sc.close();
	}

	private static void step(String distanceString) {
		int distance = Integer.parseInt(distanceString);
		
		for (int i = 0; i < distance; i++) {
			x+=(direction.X*1);
			y+=(direction.Y*1);
			
			Loc newLoc = new Loc(x,y);
			if(trail.contains(newLoc)){
				System.out.println(newLoc);
				System.exit(0);
			}
			trail.add(newLoc);
		}
		
	}
}
