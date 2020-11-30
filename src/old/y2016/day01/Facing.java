package y2016.day01;

public enum Facing {

	NORTH(0,1),
	SOUTH(0,-1),
	EAST(1,0),
	WEST(-1,0);
	
	public final int X,Y;
	
	private Facing(int x,int y) {
		X=x;Y=y;
	}
	
	public Facing turn(Direction d){
		switch (d){
		case RIGHT:
			switch(this){
			case NORTH:
				return EAST;
			case EAST:
				return SOUTH;
			case SOUTH:
				return WEST;
			case WEST:
				return NORTH;
			}
			break;
		case LEFT:
			switch(this){
			case NORTH:
				return WEST;
			case EAST:
				return NORTH;
			case SOUTH:
				return EAST;
			case WEST:
				return SOUTH;
			}
			break;
		}
		return NORTH;
	}
	
	enum Direction{
		RIGHT,LEFT
	}
}
