package y2016.day01;

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
	public boolean equals(Object obj) {
		
		if(obj instanceof Loc){
			return this.equals((Loc)obj);
		}
		return false;
	}
	@Override
	public int hashCode() {
		return x+y;
	}
	
	@Override
	public String toString() {
		return String.format("%d,%d",x,y);
	}
}
