package y2016.day02;

public class KeyPad {
	
	private Key currentLocation;
	
	public KeyPad(){
		Key one = new Key('1');
		Key two = new Key('2');
		Key three = new Key('3');
		Key four = new Key('4');
		Key five = new Key('5');
		Key six = new Key('6');
		Key seven = new Key('7');
		Key eight = new Key('8');
		Key nine = new Key('9');
		Key a = new Key('A');
		Key b = new Key('B');
		Key c = new Key('C');
		Key d = new Key('D');
		
		currentLocation = five;
		
		one.setNeighbor(Direction.DOWN, three);
		
		two.setNeighbor(Direction.RIGHT, three);
		two.setNeighbor(Direction.DOWN, six);
		
		three.setNeighbor(Direction.UP, one);
		three.setNeighbor(Direction.LEFT, two);
		three.setNeighbor(Direction.RIGHT, four);
		three.setNeighbor(Direction.DOWN, seven);
		
		four.setNeighbor(Direction.LEFT, three);
		four.setNeighbor(Direction.DOWN, eight);
		
		five.setNeighbor(Direction.RIGHT, six);
		
		six.setNeighbor(Direction.UP, two);
		six.setNeighbor(Direction.LEFT, five);
		six.setNeighbor(Direction.RIGHT, seven);
		six.setNeighbor(Direction.DOWN, a);
		
		seven.setNeighbor(Direction.UP, three);
		seven.setNeighbor(Direction.LEFT, six);
		seven.setNeighbor(Direction.RIGHT, eight);
		seven.setNeighbor(Direction.DOWN, b);
		
		eight.setNeighbor(Direction.UP, four);
		eight.setNeighbor(Direction.LEFT, seven);
		eight.setNeighbor(Direction.RIGHT, nine);
		eight.setNeighbor(Direction.DOWN, c);
		
		nine.setNeighbor(Direction.LEFT, eight);
		
		a.setNeighbor(Direction.UP, six);
		a.setNeighbor(Direction.RIGHT, b);
		
		b.setNeighbor(Direction.UP, seven);
		b.setNeighbor(Direction.LEFT, a);
		b.setNeighbor(Direction.RIGHT, c);
		b.setNeighbor(Direction.DOWN, d);
		
		c.setNeighbor(Direction.UP, eight);
		c.setNeighbor(Direction.LEFT, b);
		
		d.setNeighbor(Direction.UP, b);
	}
	
	public Key getCurrentLocation() {
		return currentLocation;
	}
	
	public Key move(Direction d){
		currentLocation= currentLocation.getNeighbor(d);
		return currentLocation;
	}
	
	
	public class Key{
		
		public final char LABEL;
		public Key UP,DOWN,LEFT,RIGHT;
		
		public Key(char label){
			LABEL=label;
		}
		
		public void setNeighbor(Direction d, Key k){
			switch (d){
			case LEFT:
				LEFT = k;
				break;
			case RIGHT:
				RIGHT = k;
				break;
			case UP:
				UP=k;
				break;
			case DOWN:
				DOWN=k;
				break;
			}
		}
		
		public Key getNeighbor(Direction d){
			Key rtn = this;
			switch (d){
			case LEFT:
				if(LEFT!=null){
					rtn=LEFT;
				}
				break;
			case RIGHT:
				if(RIGHT!=null){
					rtn=RIGHT;
				}
				break;
			case UP:
				if(UP!=null){
					rtn=UP;
				}
				break;
			case DOWN:
				if(DOWN!=null){
					rtn=DOWN;
				}
				break;
			}
			return rtn;
		}
		
		@Override
		public String toString() {
			return "key: "+LABEL;
		}
	}
	



	public enum Direction {
		LEFT,
		RIGHT,
		UP,
		DOWN
		
	}

}
