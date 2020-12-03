package y2018.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2018/day5/input"));
        String polymer = input.nextLine();//input polymer
//        String polymer = "dabAcCaCBAcCcaDA";//Test polymer
        input.close();

        int[] sizes = new int[26];

        for (char i = 'a'; i < 'a'+26; i++) {
            System.out.printf("testing %c: ", i);
            sizes[i-97]=compress(polymer.replaceAll(String.format("[%c%c]",i,Character.toUpperCase(i)),""));
            System.out.println(sizes[i-97]);
        }

        System.out.println(smallestValue(sizes));


    }

    private static int smallestValue(int[] sizes) {
        int rtn = 9999999;

        for (int i = 0; i < sizes.length; i++) {
            if(sizes[i]<rtn) rtn = sizes[i];
        }

        return rtn;
    }

    private static int compress(String polymer) {
        boolean done = false;
        top:while(!done){
            done=true;
            for (int i = 0; i < polymer.length()-1; i++) {
                if(oppositePolarity(polymer.charAt(i),polymer.charAt(i+1))){
                    done=false;
                    polymer=removePair(i,polymer);
                    continue top;
                }
            }
        }
        return polymer.length();
    }

    private static String removePair(int i, String polymer) {
        String rtn= polymer.substring(0,i)+polymer.substring(i+2);
//        System.out.println(rtn);
        return rtn;
    }

    private static boolean oppositePolarity(char o1, char o2) {
        return (o1==o2-32||o2==o1-32);
    }


}
