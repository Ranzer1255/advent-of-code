package net.ranzer.aoc.y2018.day4;

public class Guard {

    int   id;
    int   totalSleep = 0;
    int[] minsAsleep = new int[60];

    public Guard(int id) {
        this.id = id;
    }

    /**
     *
     * @param asleep minute guard falls asleep
     * @param awake minute guard wakes up
     */
    public void addNap(int asleep, int awake){
        totalSleep += (awake-asleep);
        for (int i = asleep; i < awake; i++) {
            minsAsleep[i]++;
        }
    }
}
