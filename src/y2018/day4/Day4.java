package y2018.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day4 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2018/day4/input.txt"));
        Scanner testInput = new Scanner("[1518-11-01 00:00] Guard #10 begins shift\n" +
                                        "[1518-11-01 00:05] falls asleep\n" +
                                        "[1518-11-01 00:25] wakes up\n" +
                                        "[1518-11-01 00:30] falls asleep\n" +
                                        "[1518-11-01 00:55] wakes up\n" +
                                        "[1518-11-01 23:58] Guard #99 begins shift\n" +
                                        "[1518-11-02 00:40] falls asleep\n" +
                                        "[1518-11-02 00:50] wakes up\n" +
                                        "[1518-11-03 00:05] Guard #10 begins shift\n" +
                                        "[1518-11-03 00:24] falls asleep\n" +
                                        "[1518-11-03 00:29] wakes up\n" +
                                        "[1518-11-04 00:02] Guard #99 begins shift\n" +
                                        "[1518-11-04 00:36] falls asleep\n" +
                                        "[1518-11-04 00:46] wakes up\n" +
                                        "[1518-11-05 00:03] Guard #99 begins shift\n" +
                                        "[1518-11-05 00:45] falls asleep\n" +
                                        "[1518-11-05 00:55] wakes up");

        Map<Integer,Guard> guards = new HashMap<>();

        //parse input
        int activeGuard = 0;
        int asleep=0,awake=0;
        while (input.hasNext()){
            String line = input.nextLine();
            switch (parseType(line)){
                case start:
                    activeGuard = parseGuardID(line);
                    if (guards.get(activeGuard)==null){
                        guards.put(activeGuard, new Guard(activeGuard));
                    }
                    break;
                case asleep:
                    asleep = parseTime(line);
                    break;
                case wakeup:
                    awake = parseTime(line);
                    guards.get(activeGuard).addNap(asleep,awake);
            }
        }

        //find heaviest sleeper
        int heaviestSleep = -1;
        Guard heaviestSleeper=null;

        for (Guard g : guards.values()) {
            if(g.totalSleep>heaviestSleep){
                heaviestSleep = g.totalSleep;
                heaviestSleeper = g;
            }
        }

        int mostSleep=-1, mostSleepTime=-1;
        //find their fav sleeping time
        for (int i = 0; i < heaviestSleeper.minsAsleep.length; i++) {
            if (heaviestSleeper.minsAsleep[i]>mostSleep){
                mostSleep=heaviestSleeper.minsAsleep[i];
                mostSleepTime=i;
            }
        }

        //Part 1 output
        System.out.printf("Heaviest sleeping Guard: %d, Sleepiest time: %d, checksum: %d\n",
                heaviestSleeper.id,mostSleepTime,heaviestSleeper.id*mostSleepTime);

        //part 2 start

        Guard guard = null;
        int time = -1;
        int largestTime =-1;

        for (Guard g : guards.values()) {
            System.out.println(String.format("checking guard %d",g.id));
            for (int i = 0; i < g.minsAsleep.length; i++) {
                if(g.minsAsleep[i]>largestTime){
                    largestTime=g.minsAsleep[i];
                    guard=g;
                    time=i;
                }
            }
        }
        System.out.printf("guard: %d, time %d, checksum: %d\n",
                guard.id,time,guard.id*time);

    }

    private static int parseTime(String line) {
        return Integer.parseInt(line.substring(15,17));
    }

    private static int parseGuardID(String line) {
        return Integer.parseInt(line.substring(26,line.length()-13));
    }

    private static lineType parseType(String line) {
        if(line.contains("Guard")) return lineType.start;
        else if (line.contains("asleep")) return lineType.asleep;
        else return lineType.wakeup;
    }

    private enum lineType{
        start, asleep, wakeup;
    }
}
