package y2016.day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreeSidedSquare {
	
	static File input = new File("C:/Users/jrdillingham.MABANKISD/Programing/workspace/adventofcode/src/y2016/day03/input");

	
	public static void main(String[] args) throws FileNotFoundException {
		List<Triangle> triangles = parseInput();		
		
		int count=0;
		for (Triangle triangle : triangles) {
			if(triangle.VALID) count++;
		}
		System.out.println(count);
	}


	private static List<Triangle> parseInput() throws FileNotFoundException {
		Scanner sc=new Scanner(input);
		List<Triangle> rtn = new ArrayList<>();
		
		int[][] temp = new int[3][3];
		
		int i = 0;
		while (sc.hasNextLine()) {
			int j=0;
			Scanner line = new Scanner(sc.nextLine());
			line.useDelimiter("\\s+");
			while (line.hasNextInt()) {
				temp[i][j++]=line.nextInt();
			}
			i++;
			if(i==3){
				i=0;
				for (int k = 0; k < 3; k++) {
					rtn.add(new Triangle(temp[0][k], temp[1][k], temp[2][k]));
				}
			}
			
			line.close();
		}
		
		sc.close();
		return rtn;
	}

}
