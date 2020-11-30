package y2016.day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwoFactor {
	
	static File input = new File("C:/Users/jrdillingham.MABANKISD/Programing/workspace/adventofcode/src/y2016/day08/input.txt");
//	static String input = "rect 3x2\n"
//			+ "rotate column x=1 by 1\n"
//			+ "rotate row y=0 by 4\n"
//			+ "rotate column x=1 by 1";
	static String rectRegX = "(?:rect (?<a>\\d+)x(?<b>\\d+))";
	static String rotateRegX = "(?:rotate (?:row|column) (?<direction>x|y)=(?<selection>\\d+) by (?<dist>\\d+))";
	static Pattern rect = Pattern.compile(rectRegX);
	static Pattern rotate = Pattern.compile(rotateRegX);
	static Display display = new Display();
	

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(input);
		
		
		while (sc.hasNextLine()){
			parseCommand(sc.nextLine());
		}
		
		System.out.println("num of lights: "+display.getLights());
		System.out.println(display.getDisplay());
		sc.close();
		
	}

	private static void parseCommand(String nextLine) {
		Matcher re = rect.matcher(nextLine);
		Matcher ro =rotate.matcher(nextLine);
		if(re.matches()){
			display.rect(Integer.parseInt(re.group("a")), Integer.parseInt(re.group("b")));
		} else if (ro.matches()){
			switch (ro.group("direction")){
			case "x":
				display.rotateCol(Integer.parseInt(ro.group("selection")), Integer.parseInt(ro.group("dist")));
				break;
			case "y":
				display.rotateRow(Integer.parseInt(ro.group("selection")), Integer.parseInt(ro.group("dist")));
			}
		}
		
	}
}
