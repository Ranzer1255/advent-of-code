package y2017.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {
	
	static File input = new File("C:/Users/jrdillingham.MABANKISD/Programing/workspace/adventofcode/src/y2017/day04/Day4Input");
	static List<String> passphrases = new ArrayList<>();
	
	public static void main(String[] args) {
		
		try (Scanner read = new Scanner(input)){
			while(read.hasNextLine()){
				passphrases.add(read.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int validPhrases = checkPassphrases();
		System.out.println("Part 1: "+validPhrases);
		
	}

	private static int checkPassphrases() {
		int rtn = 0;
		
		nextphrase:for (String phrase : passphrases) {
			String [] words = phrase.split("\\s");
			for (int i = 0; i < words.length; i++) {
				for (int j = i+1; j < words.length; j++) {
					if(words[i].equals(words[j])){
						continue nextphrase;
					}
					
					if (anagramCheck(words[i], words[j])) {
						continue nextphrase;
					}
				}
			}
			
			
			rtn++;
		}
		
		return rtn;
	}

	private static boolean anagramCheck(String s1, String s2) {
		if (s1.length()==s2.length()) {
			
			int matchcount = 0;
			match:for (int i = 0; i < s1.length(); i++) {
				for (int j = 0; j < s2.length(); j++) {
					//find match for char
					if(s1.charAt(i)==s2.charAt(j)){
						matchcount++;
						continue match;
					}	
				}
				break match;
			}
			if(matchcount == s1.length()){
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
