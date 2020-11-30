package y2019.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Loc {
	int x;
	int y;

	Loc (int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Loc){
			return ((Loc) obj).x==this.x && ((Loc) obj).y==this.y;
		}
		return false;
	}

	boolean equals(int x, int y){
		return this.equals(new Loc(x,y));
	}

	@Override
	public String toString() {
		return String.format("(%d,%d)",x,y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x,y);
	}

	Loc getNeighbor(Direction d){
		switch (d){
			case NORTH:
				return new Loc(this.x,this.y-1);
			case SOUTH:
				return new Loc(this.x,this.y+1);
			case EAST:
				return new Loc(this.x+1,this.y);
			case WEST:
				return new Loc(this.x-1,this.y);
			default:
				throw new IllegalStateException("Unexpected value: " + d);
		}
	}

	List<Loc> getNeighbors() {
		List<Loc> rtn = new ArrayList<>();

		rtn.add(this.getNeighbor(Direction.NORTH));
		rtn.add(this.getNeighbor(Direction.EAST));
		rtn.add(this.getNeighbor(Direction.SOUTH));
		rtn.add(this.getNeighbor(Direction.WEST));

		return rtn;
	}
}
