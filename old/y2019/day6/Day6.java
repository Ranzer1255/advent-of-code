package y2019.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day6 {
	public static void main(String[] args) throws FileNotFoundException {

		Map<String,Body> bodies = new HashMap<>();
		Scanner input = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2019/day6/input"));

		while (input.hasNext()){
			String[] in = input.next().split("\\)");
			Body orbits = bodies.get(in[0]);
			Body orbiting = bodies.get(in[1]);

			if (orbits==null){
				if(in[0].equals("COM")){
					orbits = new COM();
				}else {
					orbits = new Body(in[0]);
				}
				bodies.put(in[0],orbits);
			}
			if (orbiting==null){
				if(in[1].equals("COM")){
					orbiting = new COM();
				} else {
					orbiting = new Body(in[1]);
				}
				bodies.put(in[1],orbiting);
			}

			orbiting.setOrbit(orbits);

		}

		int numOrbits = 0;
		for (Body b :
				bodies.values()) {
			numOrbits+=b.numberOfOrbits();

		}
		System.out.println(numOrbits);

	}
}
