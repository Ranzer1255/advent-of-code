package net.ranzer.aoc.y2018.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/net.ranzer.aoc.y2018/day2/input"));
        List<String> labels = new ArrayList<>();
        List<String> twos = new ArrayList<>();
        List<String> threes = new ArrayList<>();

        while(input.hasNext()){
            labels.add(input.nextLine());
        }

        String[] testInput = {
                "abcde",
                "fghij",
                "klmno",
                "pqrst",
                "fguij",
                "axcye",
                "wvxyz"
        };

//        labels.addAll(Arrays.asList(testInput));

//        for (String label:labels) {
//            System.out.printf("checking: %s\n",label);
//            int[] chars = countChars(label);
//
//            if (hasCount(chars, 2)){
//                twos.add(label);
//            }
//            if (hasCount(chars, 3)){
//                threes.add(label);
//            }
//        }
//        System.out.println("twos: "+twos.size());
//        System.out.println("threes: "+threes.size());
//        System.out.println(twos.size()*threes.size());

        for (int i = 0; i < labels.size(); i++) {
            for (int j = i+1; j < labels.size(); j++) {
                int difference = countDifference(labels.get(i),labels.get(j));
                System.out.println(difference);
                if (difference == 1){
                    int diffIndex = getDiffIndex(labels.get(i), labels.get(j));
                    System.out.println(diffIndex);
//                    System.out.println(labels.get(i));
                    System.out.println(labels.get(i).substring(0,diffIndex) + labels.get(i).substring(diffIndex+1));
                    System.exit(0);
                }
            }
        }
    }

    private static int getDiffIndex(String o1, String o2) {
        for (int i = 0; i < o1.length(); i++) {
            if (o1.charAt(i) != o2.charAt(i))
                return i;
        }
        return -1;
    }

    private static int countDifference(String o1, String o2) {
        int rtn = 0;

        for (int i = 0; i < o1.length(); i++) {
            if (o1.charAt(i)!=o2.charAt(i))
                rtn++;
        }

        return rtn;
    }

    private static boolean hasCount(int[] chars, int count) {

        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==count)
                return true;
        }
        return false;
    }

    private static int[] countChars(String label) {
        int[] rtn = new int[26];

        for (int i = 0; i < label.length(); i++) {
            rtn[label.charAt(i)-97]++;
        }

        return rtn;
    }
}
