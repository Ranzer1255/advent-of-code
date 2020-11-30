package y2019.day15;

enum Direction {
	NORTH(1),
	SOUTH(2),
	WEST(3),
	EAST(4);
	final int code;
	Direction(int code){
		this.code = code;
	}

	public static Direction get(int code) {
		switch (code){
			case 1:
				return NORTH;
			case 2:
				return SOUTH;
			case 3:
				return WEST;
			case 4:
				return EAST;
			default:
				throw new IllegalStateException("Unexpected value: " + code);
		}
	}

	public static Direction reverse(Direction d){
		switch (d){
			case SOUTH:
				return NORTH;
			case NORTH:
				return SOUTH;
			case WEST:
				return EAST;
			case EAST:
				return WEST;
			default:
				throw new IllegalStateException("Unexpected value: " + d);
		}
	}

	public static Direction left(Direction d){
		switch (d) {
			case SOUTH:
				return EAST;
			case NORTH:
				return WEST;
			case WEST:
				return SOUTH;
			case EAST:
				return NORTH;
			default:
				throw new IllegalStateException("Unexpected value: " + d);
		}
	}
	public static Direction right(Direction d){
		switch (d) {
			case SOUTH:
				return WEST;
			case NORTH:
				return EAST;
			case WEST:
				return NORTH;
			case EAST:
				return SOUTH;
			default:
				throw new IllegalStateException("Unexpected value: " + d);
		}
	}


}
