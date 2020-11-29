package y2015.day02;

import framework.Day;
import framework.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02 extends Day {

	private List<Package> packages = new ArrayList();
	public Day02(){
		input = Input.getScanner(2015,2);
		while (input.hasNext()){
			packages.add(new Package(input.nextLine()));
		}
	}

	@Override
	public void part1() {
		int totalSqrFootage = 0;

		for (Package p : packages){
			totalSqrFootage += p.SurfaceArea()+p.smallSideArea();
		}

		System.out.println(totalSqrFootage);

	}

	@Override
	public void part2() {

		int totalRibbon = 0;

		for (Package p : packages){
			totalRibbon += p.volume()+p.smallPerm();
		}

		System.out.println(totalRibbon);



	}

	private class Package {
		Pattern pattern = Pattern.compile("(?<x>\\d+)x(?<y>\\d+)x(?<z>\\d+)");

		int x, y, z;

		public Package(String dims){
			Matcher m = pattern.matcher(dims);
			m.find();

			this.x = Integer.parseInt(m.group("x"));
			this.y = Integer.parseInt(m.group("y"));
			this.z = Integer.parseInt(m.group("z"));

		}
		public Package(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public int smallSideArea(){
			int rtn = x*y;
			if(x*z < rtn) rtn = x*z;
			if(y*z < rtn) rtn = y*z;

			return rtn;
		}

		public int SurfaceArea(){
			return (2*x*y)+(2*x*z)+(2*y*z);
		}

		public int volume(){
			return x*y*z;
		}

		public int smallPerm(){
			int rtn = (2*x)+(2*y);
			if (2*x+2*z<rtn) rtn = 2*x+2*z;
			if (2*y+2*z<rtn) rtn = 2*y+2*z;
			return rtn;
		}
	}
}
