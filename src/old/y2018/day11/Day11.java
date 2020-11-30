package y2018.day11;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

public class Day11 {
    public static void main(String[] args) {
        int serialNumber = 2568;
        int[][] grid =  generateGrid(serialNumber);

        Map<Integer,Map.Entry<Point,Integer>> highestPerCursor = new TreeMap<>();

        for (int i = 0; i < 300; i++) {
            System.out.println("calculating cursor size "+i);
            int finalI = i;
            calculateTotals(grid, i).entrySet().stream().sorted(Map.Entry.comparingByValue((v1, v2)-> v1.compareTo(v2)*-1)).
                    findFirst().ifPresent(o -> highestPerCursor.put(finalI, o));

        }

        highestPerCursor.entrySet().stream().sorted(Map.Entry.comparingByValue(Map.Entry.comparingByValue((v1, v2)-> v1.compareTo(v2)*-1))).findFirst().ifPresent(o->{
            System.out.println(String.format("highest power %d at %d,%d with cursor size of %d",
                    o.getValue().getValue(),o.getValue().getKey().x,o.getValue().getKey().y,o.getKey()));
        });
    }

    private static Map<Point, Integer> calculateTotals(int[][] grid,int cursorSize) {
        Map<Point, Integer> rtn = new HashMap<>();

        if (cursorSize == grid.length) {
            int sum = 0;
            for (int i = 0; i < cursorSize; i++) {
                for (int j = 0; j < cursorSize; j++) {
                    sum += grid[i][j];
                }
            }
            rtn.put(new Point(1,1),sum);
        } else {
            for (int x = 0; x < grid.length-cursorSize; x++) {
                for (int y = 0; y < grid[x].length-cursorSize; y++) {
                    int sum = 0;
                    for (int i = x; i < x+cursorSize; i++) {
                        for (int j = y; j < y+cursorSize; j++) {
                            sum += grid[i][j];
                        }
                    }
                    rtn.put(new Point(x,y),sum);
                }
            }
        }
        return rtn;
    }

    private static int[][] generateGrid(int serialNumber) {
        int[][] rtn =  new int[300][300];

        for (int x = 0; x < rtn.length; x++) {
            for (int y = 0; y < rtn[x].length; y++) {
                int rackID = x + 10;
                int powerLevel = rackID*y;
                powerLevel += serialNumber;
                powerLevel *= rackID;


                int digit = 0;
                if (powerLevel>99) {
                    digit = Character.digit(String.valueOf(powerLevel).charAt(String.valueOf(powerLevel).length()-3),10);
                }
                powerLevel=digit-5;
                rtn[x][y] = powerLevel;
            }
        }
        return rtn;
    }
}
