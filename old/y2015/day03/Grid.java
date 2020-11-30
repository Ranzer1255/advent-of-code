package y2015.day03;

import java.util.HashMap;
import java.util.Map;

public class Grid {
	
	private static Map<Loc,Cell> grid = new HashMap<>();
	public static int uniqueVisits=1;
	
	private Loc currentLocation = new Loc(0,0);
	private Cell currentCell = new Cell(currentLocation);
	
	public Grid(){
		grid.put(currentLocation, currentCell);
		System.out.println(currentLocation);
	}
	
	
	
	public void move(Direction direction){
		Loc newLocation = new Loc(currentLocation.x+direction.X,currentLocation.y+direction.Y);
		System.out.println("moved "+direction+ " to "+newLocation);
		Cell newCell;
		if (grid.containsKey(newLocation)) {
			newCell=grid.get(newLocation);
		} else {
			newCell = new Cell(newLocation);
			grid.put(newLocation, newCell);
			uniqueVisits++;
		}
		newCell.visit();
		currentCell=newCell;
		currentLocation=newLocation;
	}
	
	public static int uniqueVisits(){
		return grid.size();
	}
	
	
	
	
	
	public class Cell{
		public final Loc loc;
		private int visits;
		
		public Cell(Loc loc){
			this.loc = loc;
			visits=1;
		}
		
		public void visit(){
			visits++;
		}
		public int getVisits(){
			return visits;
		}
	}
	
	public class Loc{
		public final int x,y;
		
		Loc(int x, int y){
			this.x=x;this.y=y;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Loc) {
				if(this.x==((Loc)obj).x&&this.y==((Loc)obj).y) return true;
			}
			return false;
		}
		@Override
		public int hashCode() {
			return x+y;
		}
		
		@Override
		public String toString() {
			return "current location is: " +x+", "+y;
		}
	}

}
