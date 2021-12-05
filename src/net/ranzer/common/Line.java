package net.ranzer.common;

import java.util.List;
import java.util.Objects;

public class Line {

	public final Loc p1;
	public final Loc p2;

	public Line(Loc p1, Loc p2){
		this.p1 = p1;
		this.p2 = p2;
	}

	public boolean isOrthogonal(){
		return isHorizontal() || isVertical();
	}

	public boolean isVertical() {
		return p1.Y==p2.Y;
	}

	public boolean isHorizontal(){
		return p1.X==p2.X;
	}

	public static boolean onLineSegment(Line line, Loc p){

		if(!inBounds(line,p)) return false;

		if(line.isHorizontal()){
			return p.X==line.p1.X;
		}

		if(line.isVertical()){
			return p.Y==line.p1.Y;
		}

		return Math.abs(line.p1.X- p.X) == Math.abs(line.p1.Y-p.Y);
	}

	public static boolean inBounds(Line line, Loc p){
		int max_x = Math.max(line.p1.X,line.p2.X);
		int max_y = Math.max(line.p1.Y,line.p2.Y);
		int min_x = Math.min(line.p1.X,line.p2.X);
		int min_y = Math.min(line.p1.Y,line.p2.Y);

		return p.X<=max_x && p.X >=min_x && p.Y<=max_y && p.Y>=min_y;
	}

	public static Loc maxSize(List<Line> lines){
		int max_x=-1, max_y=-1;
		for (Line l :lines){
			if(l.p1.X>max_x) max_x=l.p1.X;
			if(l.p2.X>max_x) max_x=l.p2.X;
			if(l.p1.Y>max_y) max_y=l.p1.Y;
			if(l.p2.Y>max_y) max_y=l.p2.Y;
		}
		return new Loc(max_x,max_y);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Line line = (Line) o;
		return p1.equals(line.p1) && p2.equals(line.p2);
	}

	@Override
	public int hashCode() {
		return Objects.hash(p1, p2);
	}

	@Override
	public String toString(){
		return p1 + " -> " +p2;
	}
}
