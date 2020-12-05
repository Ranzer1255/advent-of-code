package net.ranzer.aoc.y2018.day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day07 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/net.ranzer.aoc.y2018/day7/input"));
//        Scanner input = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/net.ranzer.aoc.y2018/day7/testInput.txt"));

        int numWorkers = 5;
        List<Worker> workers = new ArrayList<>(numWorkers);
        for (int i = 0; i < numWorkers; i++) {
            workers.add(new Worker());
        }

        Map<Character, Step> steps = new TreeMap<>();

        while (input.hasNext()) {
            String line = input.nextLine();
            char prereq = line.charAt(5);
            char step = line.charAt(37);
            if (!steps.containsKey(step)) {
                steps.put(step, new Step(step));
            }
            if (!steps.containsKey(prereq)) {
                steps.put(prereq, new Step(prereq));
            }
            steps.get(step).addPrereq(steps.get(prereq));
            steps.get(prereq).addDependent(steps.get(step));
        }

        TreeMap<Character, Step> queue = new TreeMap<>();

        for (Step s : steps.values()) {
            System.out.printf("step %c: prereq length: %d \n",s.label,s.prereqs.size());
            if(s.ready())
                queue.put(s.label,s);
        }

        int time = 0;
        StringBuilder done = new StringBuilder();

//        while(!queue.isEmpty()){
//            Step s = queue.remove(queue.firstKey());
//            done.append(s.use());
//            for (Step t :
//                    s.getDependents()) {
//                if (t.ready()) queue.put(t.label,t);
//            }
//
//        }
//        System.out.println(done);

        while (true) {
            System.out.printf("%d: ", time++);
            workers.stream().forEach(o-> System.out.printf("%c ",o.workingOn()));
            System.out.println(done);

            for (Worker w : workers) {
                if (!queue.isEmpty() && !w.working()) {
                    w.setJob(queue.remove(queue.firstKey()));
                }
            }

            for (Worker w: workers) {
                if (w.working()){
                    w.tick();
                    if (w.isDone()){
                        done.append(w.step.use());
                        for (Step s :
                                w.step.getDependents()) {
                            if(s.ready()) queue.put(s.label,s);
                        }
                        if(!queue.isEmpty())
                            w.setJob(queue.remove(queue.firstKey()));
                    }
                }
            }
            if(!workersWorking(workers)&&queue.isEmpty()) break;
        }
        System.out.println(time);
    }

    private static boolean workersWorking(List<Worker> workers) {
        for (Worker w : workers) {
            if (w.working()) return true;
        }
        return false;
    }
}
