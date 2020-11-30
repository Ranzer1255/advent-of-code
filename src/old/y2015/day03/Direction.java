package y2015.day03;

public enum Direction {
	UP(0,1),DOWN(0,-1),LEFT(-1,0),RIGHT(1,0);
	
	public final int X,Y;
	
	Direction(int x, int y){
		X=x;Y=y;
	}

}
