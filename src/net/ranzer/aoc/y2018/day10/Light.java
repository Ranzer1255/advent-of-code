package net.ranzer.aoc.y2018.day10;

import java.awt.*;

public class Light {

    Point position;
    int vX, vY;

    public Light(int x,int y,int vx,int vy){
        position = new Point(x,y);
        vX =vx;
        vY =vy;
    }

    @Override
    public String toString() {
        return String.format("pos=%d,%d vel=%d, %d",position.x,position.y, vX, vY);
    }

    public void tick(){
        position.translate(vX,vY);
    }
    public void backTick(){
        position.translate(-vX,-vY);
    }
}
