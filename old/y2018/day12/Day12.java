package y2018.day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Day12 {
    public static void main(String[] args) throws FileNotFoundException {
        String initialState = "#.#..#..###.###.#..###.#####...########.#...#####...##.#....#.####.#.#..#..#.#..###...#..#.#....##.";
        long generations = 50_000_000_000L;

        List<Rule> rules = getRules();
        TreeMap<Integer,Pot> pots = new TreeMap<>();

        for (int i = 0; i < initialState.length(); i++) {
            pots.put(i,new Pot(i, initialState.charAt(i)));
        }

        //generational tick loop
        for (long g = 0; g < generations; g++) {

            System.out.println(g);

            //scan across all pots plus the 2 pots ether side of the end pots
            for (int pot = pots.firstKey()-2; pot < pots.size()+2; pot++) {
                if(pots.containsKey(pot)){

                    //check existing pots against rules
                    for (Rule r : rules) {
                        if (r.applies(pots.get(pot - 2), pots.get(pot - 1), pots.get(pot), pots.get(pot + 1), pots.get(pot + 2))) {
                            pots.get(pot).setPlanted(r.result);
                        }
                    }

                } else {
                    Pot p = new Pot(pot,false);
                    //check edge and gap pots against rules
                    for (Rule r : rules){
                        if (r.applies(pots.get(pot - 2), pots.get(pot - 1), p, pots.get(pot + 1), pots.get(pot + 2))) {
                            if (r.result){
                                p.setPlanted(true);
                                pots.put(pot, p);
                            }
                        }
                    }
                }
            }

            for (Pot p : pots.values()) {
                p.tick();
            }
        }

        int sum = pots.values().stream().filter(Pot::isPlanted).mapToInt(o -> o.number).sum();
        System.out.println(sum);

    }

    private static List<Rule> getRules() throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2018/day12/rules.txt"));
        List<Rule> rtn = new ArrayList<>();

        while (input.hasNextLine()){
            String line = input.nextLine();
            rtn.add(new Rule(line.substring(0,5),line.charAt(line.length()-1)));
        }

        return rtn;
    }


}
