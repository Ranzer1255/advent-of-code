package y2019.day6;

public class Body {
	public String name;
	private Body orbits;

	public Body(String name){
		this.name = name;
	}

	public Body(String name, Body orbits){
		this(name);
		this.orbits=orbits;
	}

	public int numberOfOrbits(){
		return orbits.numberOfOrbits()+1;
	}

	public void setOrbit(Body body){
		orbits = body;
	}

//	public List<Body> indirectOrbits(){
//
//
//		return orbits.in
//	}

}
