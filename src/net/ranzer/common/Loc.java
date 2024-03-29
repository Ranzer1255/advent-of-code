package net.ranzer.common;

import java.util.Objects;

/**
 * represents a 2D position in space with an X and Y coordinate
 *
 * @author Ranzer
 */
public class Loc {

	public final int X,Y;
	public Loc(int x, int y){
		X=x;
		Y=y;
	}

	/**
	 *
	 * @return new Loc with the Coords: X, Y+1
	 */
	public Loc up() {
		return new Loc(X,Y+1);
	}

	/**
	 *
	 * @return new Loc with the Coords: X, Y-1
	 */
	public Loc down() {
		return new Loc(X,Y-1);
	}

	/**
	 *
	 * @return new Loc with the Coords: X-1, Y
	 */
	public Loc left() {
		return new Loc(X-1,Y);
	}

	/**
	 *
	 * @return new Loc with the Coords: X+1, Y
	 */
	public Loc right() {
		return new Loc(X+1,Y);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Loc loc = (Loc) o;
		return X == loc.X &&
				Y == loc.Y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(X, Y);
	}

	@Override
	public String toString() {
		return X + "," +Y;
	}
}
