package net.ranzer.aoc.y2021.day02;

public class Sub {

	int x_position = 0;
	int depth = 0;
	int aim = 0;

	public void command(Direction direction, int distance){

		System.out.println("moving " + direction.direction);

		switch (direction){
			case UP:
				aim -= distance;
				break;
			case DOWN:
				aim += distance;
				break;
			case FORWARD:
				x_position += distance;
				depth += (distance * aim);
		}
//		System.out.printf("aim: %d\ndepth: %d\n",aim, depth);
	}

	public enum Direction{
		UP("up"),
		DOWN("down"),
		FORWARD("forward");

		public final String direction;

		Direction(String text){
			this.direction = text;
		}

		public static Direction fromString(String value){
			for (Direction d : Direction.values()){
				if (d.direction.equals(value)) return d;
			}
			throw new IllegalArgumentException("No constant with text " + value + " found");
		}
	}

	public static class Command{
		Direction direction;
		int distance;

		Command(String direction, int distance){
			this.direction = Direction.fromString(direction);
			this.distance = distance;
		}

		@Override
		public String toString() {
			return direction.direction +
					" " + distance;
		}
	}
}
