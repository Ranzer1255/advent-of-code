package y2015.day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {
	
	static File input = new File(System.getProperty("user.dir")+"/src/y2015/day05/day5input.txt");
	static List<String> niceList = new ArrayList<>();
	static List<String> naughtyList = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner read = new Scanner(input);
		
		ArrayList<String> strings = new ArrayList<>();
		while (read.hasNextLine()){
			strings.add(read.nextLine());
		}
		read.close();
		
		for (String string : strings) {
			if(nicePart2(string)){
				niceList.add(string);
			} else {
				naughtyList.add(string);
			}
		}
		
		System.out.println(niceList.size());

		
	}

	private static boolean nicePart2(String string) {
		Pattern letterPairs = Pattern.compile("(.{2}).*\\1");
		Pattern letterSamich = Pattern.compile("(.).\\1");
		Matcher pair = letterPairs.matcher(string);
		Matcher samich = letterSamich.matcher(string);
		return (pair.find()&&samich.find());
	}

	@SuppressWarnings("unused")
	private static boolean nicePart1(String string) {
		System.out.println(string);
		boolean rtn=false;
		
		Pattern vowels = Pattern.compile("[aeiou]");
		Pattern doubles = Pattern.compile("([a-zA-Z])\\1");
		Pattern naughty = Pattern.compile("(ab)|(cd)|(pq)|(xy)");
		
		System.out.println("naughty: "+naughty.matcher(string).find());
		if(naughty.matcher(string).find()) return false;
		
		System.out.println("Doubles: "+doubles.matcher(string).find());
		System.out.println("one vowel: "+vowels.matcher(string).find());
		if(doubles.matcher(string).find()){
			int vowelCount = 0;
			Matcher m = vowels.matcher(string);
			while(m.find()){
				vowelCount++;;
			}
			if (vowelCount>=3) {
				rtn=true;
			}
		}
		
		return rtn;
	}

}
