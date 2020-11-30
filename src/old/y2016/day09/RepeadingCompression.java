package y2016.day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeadingCompression {
	
	static File input = new File("C:/Users/jrdillingham.MABANKISD/Programing/workspace/adventofcode/src/y2016/day09/input.txt");
//	static String input = "(3x3)xyz";
	static Pattern repeat = Pattern.compile("\\((\\d+)x(\\d+)\\)");

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(input);
		String in = sc.nextLine();
		sc.close();
		
		
		
		
		//one pass decompression
		System.out.println(decompress(in).length());
		
		
		

	}
	
	private static String decompress(String in){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<in.length();i++){
			if(in.charAt(i)=='('){
				int close = in.indexOf(')',i);
				Matcher m = repeat.matcher(in.substring(i, close+1));
				m.matches();
				String add = in.substring(close+1,close+1+Integer.parseInt(m.group(1)));
				i=close+add.length();
				
				for (int j=0;j<Integer.parseInt(m.group(2));j++) {
					sb.append(add);
				}
			} else {
				sb.append(in.charAt(i));
			}
		}
		return sb.toString();
	}

}
