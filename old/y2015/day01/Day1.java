package old.y2015.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Day1 {
	
	static File input =new File("./src/y2015/day01/day1input.txt");
	
	public static void main(String[] args) {
		int floor = 0;
		try(Scanner read = new Scanner(input)){
			String inpt = read.nextLine();
			for (int i = 0; i < inpt.length(); i++) {
				switch (inpt.charAt(i)) {
				case '(':
					floor++;
					break;
				case ')':
					floor--;
					break;
				}
				if(floor==-1){
					System.out.println("basement at step "+(i+1));
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(floor);
	}

}
