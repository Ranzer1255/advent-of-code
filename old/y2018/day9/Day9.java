package y2018.day9;

import java.util.Arrays;

public class Day9 {
    public static void main(String[] args) {

        int numPlayers = 493;
        int lastMarble = 7186300;

        long[] players = new long[numPlayers];
        int activePlayer = 0;

        CircleGame circle = new CircleGame();

        for (int i = 1; i <= lastMarble; i++) {
//            System.out.println(activePlayer);
            players[i%numPlayers] += circle.addMarble(i);
//            System.out.println(Arrays.toString(circle.getCircle().toArray())+" active marble: "+circle.getActiveMarble());
        }
        System.out.println(Arrays.toString(players));
        Arrays.sort(players);
        System.out.println(players[players.length-1]);
    }
}