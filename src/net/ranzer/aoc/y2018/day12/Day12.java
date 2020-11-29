package net.ranzer.aoc.y2018.day12;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Day12 {
    public static void main(String[] args) {
        String initialState = "#.#..#..###.###.#..###.#####...########.#...#####...##.#....#.####.#.#..#..#.#..###...#..#.#....##.";
        int generations = 20;

        List<Rule> rules = getRules();
        Map<Integer,Pot> pots = new TreeMap<>();

        for (int i = 0; i < initialState.length(); i++) {
            pots.put(i,new Pot(i, initialState.charAt(i)));
        }

        for (int g = 0; g < generations; g++) {
            for (int pot = -2; pot < pots.size()+2; pot++) {
                if(pots.containsKey(pot)){
                    
                }
            }
        }

    }

    private static List<Rule> getRules() {//TODO
        return null;
    }


}
