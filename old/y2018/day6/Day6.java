package y2018.day6;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day6 {//not my code sadly i was stumped

    public static void main(String[] args) throws FileNotFoundException {
        new Day6();
    }



    public Day6() throws FileNotFoundException {
        //* Toggle comment - switch start of this line between /* and //* to toggle which section of code is active.
        Scanner file = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2018/day6/input.txt"));

        ArrayList<String> input = new ArrayList<>();
        while(file.hasNext()){
            input.add(file.nextLine());
        }

        HashMap<Integer, Point> points = new HashMap<Integer, Point>();

        int maxx = 0;
        int maxy = 0;
        int count = 0;
        for (String str : input) {

            String s[] = str.trim().split(", ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            points.put(count, new Point(x, y));
            count++;
            if (x > maxx) {
                maxx = x;
            }
            if (y > maxy) {
                maxy = y;
            }
        }

        int[][] grid = new int[maxx + 1][maxy + 1];
        HashMap<Integer, Integer> regions = new HashMap<Integer, Integer>();

        for (int x = 0; x <= maxx; x++) {
            for (int y = 0; y <= maxy; y++) {

                int best = maxx + maxy;
                int bestnum = -1;

                // find distance to closest point
                for (int i = 0; i < count; i++) {
                    Point p = points.get(i);

                    int dist = Math.abs(x - p.x) + Math.abs(y - p.y);
                    if (dist < best) {
                        best = dist;
                        bestnum = i;
                    } else if (dist == best) {
                        bestnum = -1;
                    }
                }

                grid[x][y] = bestnum;
                Integer total = regions.get(bestnum);
                if (total == null) {
                    total = new Integer(1);
                } else {
                    total = total.intValue() + 1;
                }
                regions.put(bestnum, total);
            }
        }

        // remove infinite
        for (int x = 0; x <= maxx; x++) {
            int bad = grid[x][0];
            regions.remove(bad);
            bad = grid[x][maxy];
            regions.remove(bad);
        }
        for (int y = 0; y <= maxy; y++) {
            int bad = grid[0][y];
            regions.remove(bad);
            bad = grid[maxx][y];
            regions.remove(bad);
        }

        // find biggest
        int biggest = 0;
        for (int size : regions.values()) {
            if (size > biggest) {
                biggest = size;
            }
        }

        System.out.println("Biggest: " + biggest);

        int inarea = 0;

        for (int x = 0; x <= maxx; x++) {
            for (int y = 0; y <= maxy; y++) {

                int size = 0;
                for (int i = 0; i < count; i++) {
                    Point p = points.get(i);
                    int dist = Math.abs(x - p.x) + Math.abs(y - p.y);
                    size += dist;
                }

                if (size < 10000) {
                    inarea++;
                }

            }
        }

        System.out.println("Area Size: " + inarea);
    }

}
