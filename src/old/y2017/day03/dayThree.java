package y2017.day03;

import java.util.HashMap;
import java.util.Map;

public class dayThree {

	public static int input= 289326;
	
	
	public static void main(String[] args) {
		
		buildMemory();
		
		System.out.println(partOne());
		System.out.println(partTwo());

	}
	
	private static void buildMemory() {
		// TODO Auto-generated method stub
		
	}

	public static String partOne(){
		
		
		return "Day 3 part 1: ";
	}
	
	public static String partTwo(){
		
		return "Day 3 part 2: ";
	}
	
	public class SpiralMemory {
		
		private Map<Loc,Cell> memory= new HashMap<>();
		
		public SpiralMemory(int size){
			for (int i=0; i<size; i++) {
				
			}
		}
		
		public class Cell{
			public final int name;
			public final Loc loc;
			public Cell(int x, int y, int name){
				loc = new Loc(x,y);
				this.name=name;
			}
		}
		
		public class Loc{
			public final int x,y;
			public Loc(int x,int y){
				this.x=x;
				this.y=y;
			}

			public boolean equals(Loc l) {
				return (this.x==l.x&&this.y==l.y);
			}
			
			@Override
			public int hashCode() {
				return x+y;
			}
		}
	}

}
