package net.ranzer.aoc.y2018.day9;

import java.util.ArrayDeque;

public class CircleGame {

    private CircleDeque<Integer> circle = new CircleDeque<>();

    public CircleGame(){
        circle.addFirst(0);
    }

    /**
     * this method adds a marble into the approprate location relitive to the active marble
     * @param value the value of the marble being added
     * @return points earned if any
     */
    public int addMarble(int value){
        int rtn = 0;

        if (value%23==0){
            rtn+=value;
            circle.rotate(-7);
            rtn+=circle.pop();
        } else {
            circle.rotate(2);
            circle.addLast(value);
        }
        return rtn;
    }

    public class CircleDeque<T> extends ArrayDeque<T> {

        void rotate(int num){
            if (num==0) return;

            if(num>0){
                for (int i = 0; i < num; i++) {
                    T t = this.removeLast();
                    this.addFirst(t);
                }
            } else {
                for (int i = 0; i < Math.abs(num)-1; i++) {
                    T t = this.remove();
                    this.addLast(t);
                }
            }
        }
    }
}
