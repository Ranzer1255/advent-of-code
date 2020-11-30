package y2019.day4;

import java.util.*;

public class Day4 {
	public static void main(String[] args) {
		final int SRT = 136760;
		final int END = 595730;

//		System.out.println(testNumber(225999));

		int validCount = 0;
		for (int i = SRT; i <= END; i++){

			System.out.println("Testing: "+i);
			if(testNumber(i)) {
				System.out.println("valid!");
				validCount++;
			}
		}
		System.out.println("count: "+validCount);
	}

	private static boolean testNumber(int number){

		if (!isIncreasing(number)) return false;

		return doubleDigit(number);
	}

	private static boolean doubleDigit(int number) {
		//TODO
		int count[] = new int[10];
		Arrays.fill(count, 0);

		Stack<Integer> digits = new Stack<>();

		while (number>0){
			digits.push(number%10);
			number=number/10;
		}

		while(!digits.empty()){
			count[digits.pop()]++;
		}
		for (int i = 0; i < 10; i++) if (count[i] == 2) return true;
		return false;
	}

	private static boolean isIncreasing(int number) {

		Stack<Integer> digits = new Stack<>();

		while (number>0){
			digits.push(number%10);
			number=number/10;
		}
		int last = -1;
		while (!digits.empty()){
			int current =digits.pop();
			if (current<last) return false;
			last = current;
		}
		return true;
	}


}
