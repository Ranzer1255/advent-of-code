package y2018.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2018/day3/input"));
        String[] testInput = {
                "#1 @ 1,3: 4x4",
                "#2 @ 3,1: 4x4",
                "#3 @ 5,5: 2x2"
        };

        int[][] fabric = new int[1000][1000];

        List<Claim> claims = new ArrayList<>();

        while (input.hasNext()){
            claims.add(new Claim(input.nextLine()));
        }

//        for (String claim: testInput) {
//            claims.add(new Claim(claim));
//        }

        //marking pass
        for (Claim claim : claims) {
            System.out.println("marking claim "+claim);

            for (int i =claim.x+claim.w; i > claim.x ; i--) {
                for (int j =claim.y+claim.h; j >claim.y ; j--) {
                    fabric[i][j]++;
                }
            }
        }

        //overlap pass
        for (Claim claim : claims) {

            for (int i =claim.x+claim.w; i > claim.x ; i--) {
                for (int j =claim.y+claim.h; j >claim.y ; j--) {
                    if(fabric[i][j]>1) claim.overlap=true;
                }
            }
        }

        for (Claim claim : claims) {
//            System.out.println(claim);
            if(!claim.overlap) {
                System.out.println(claim.id);
//                System.exit(0);
            }
        }
//        printOut(fabric);
    }

    private static void printOut(int[][] fabric) {
        for (int i = 0 ; i < fabric.length; i++) {
            for (int j = 0; j < fabric[i].length; j++) {
                System.out.print(fabric[i][j]==0? "" :fabric[i][j]);
            }
            System.out.println();
        }

    }

    static private class Claim{
        public final int id, x, y, w, h;
        boolean overlap = false;
        private final Pattern pattern = Pattern.compile("#(?<id>\\d+) @ (?<x>\\d+),(?<y>\\d+): (?<w>\\d+)x(?<h>\\d+)");

        public Claim(String clame){
            Matcher m = pattern.matcher(clame);
            m.find();
            id=Integer.parseInt(m.group("id"));
            x=Integer.parseInt(m.group("x"))-1;
            y=Integer.parseInt(m.group("y"))-1;
            w=Integer.parseInt(m.group("w"));
            h=Integer.parseInt(m.group("h"));

        }

        @Override
        public String toString() {
            return String.format("#%d @ %d,%d: %dx%d overlap:%b",id,x,y,w,h,overlap);
        }
    }
}
