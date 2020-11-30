package y2018.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day8 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2018/day8/input.txt"));
//        Scanner input = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2018/day8/testInput.txt"));
        input.useDelimiter(" ");

        List<Integer> inputStream = new ArrayList<>();
        while (input.hasNextInt()){
            inputStream.add(input.nextInt());
        }

        Node root = new Node(inputStream.remove(0),inputStream.remove(0),inputStream);
        System.out.println(root.metaSum());
        System.out.println(root.value());
    }
}
