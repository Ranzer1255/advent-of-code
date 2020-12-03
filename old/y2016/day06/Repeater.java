package y2016.day06;

import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Repeater {

	static File input = new File("C:/Users/sgman/programing/java/workspace/adventOfCode2017/src/y2016/day06/input");
	
	/*static String input = "eedadn\n"+
						  "drvtee\n"+
						  "eandsr\n"+
						  "raavrd\n"+
						  "atevrs\n"+
						  "tsrnev\n"+
						  "sdttsa\n"+
						  "rasrtv\n"+
						  "nssdts\n"+
						  "ntnada\n"+
						  "svetve\n"+
						  "tesnvt\n"+
						  "vntsnd\n"+
						  "vrdear\n"+
						  "dvrsen\n"+
						  "enarar\n";*/
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(input);
		List<List<Character>> colums = new ArrayList<>();
		
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			
			for (int i = 0; i < line.length(); i++) {
				if(colums.size()<=i) colums.add(new ArrayList<>());
				colums.get(i).add(line.charAt(i));
			}
		}
		
		for (List<Character> list : colums) {
			Map<Character, Long> count = 
			list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
			
			System.out.print(count.entrySet().stream().sorted((o1,o2)->{
				return o1.getValue().compareTo(o2.getValue());
			}).findFirst().get().getKey());
		}
		
	}

}
