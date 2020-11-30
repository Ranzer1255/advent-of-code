package y2018.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2018/day1/input.txt"));

        List<Integer> freqs = new ArrayList<>();
        List<Integer> freqChanges = new ArrayList<>();

        while(input.hasNext()) {
            freqChanges.add(input.nextInt());
        }
        int solution = 0;
        int loop = 0;
        top:while(true){
            System.out.println(loop++);
            for (int i = 0; i < freqChanges.size(); i++){
                solution += freqChanges.get(i);
                if(freqs.contains(solution)) {
                    System.out.println(solution);
                    break top;
                } else
                    freqs.add(solution);
            }
        }
    }
}
