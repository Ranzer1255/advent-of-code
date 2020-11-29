package y2018.day10;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day10 {
    public static void main(String[] args) throws FileNotFoundException {

        List<Light> lights = parseInput();


        //find the second with the lowest bounding box
        boolean shrinking = true;
        int boundingWidth=Integer.MAX_VALUE, boundingHeight=Integer.MAX_VALUE;
        int second = 0;

        while (shrinking){
            //tick all lights
            second++;
            for (Light l :
                    lights) {
                l.tick();
            }

            //find current bounding box
            Point boundBox = getBoundBox(lights);

            if (boundBox.x< boundingWidth){
                boundingWidth = boundBox.x;
            }

            //is smaller than last box?
            if (boundBox.y < boundingHeight){
                boundingHeight = boundBox.y;
            } else {
                shrinking=false;
                System.out.println(--second);
                for (Light l :
                        lights ) {
                    l.backTick();
                }
            }

        }

        printLights(lights);

    }

    private static Point getBoundBox(List<Light> lights) {
        int maxX =0, maxY=0;
        for (int i = 0; i < lights.size(); i++) {
            for (int j = i+1; j < lights.size(); j++) {
                Point distance = getDistance(lights.get(i).position,lights.get(j).position);
                if (maxX < distance.x) maxX=distance.x;
                if (maxY < distance.y) maxY=distance.y;
            }

        }

        return new Point(maxX,maxY);
    }

    private static void printLights(List<Light> lights) {


        Point boundBox = getBoundBox(lights);
        System.out.println(boundBox);

        char[][] sky = new char[boundBox.y+1][boundBox.x+1];
        for (int i = 0; i < sky.length; i++) {

            Arrays.fill(sky[i], ' ');
        }
        int minX = Integer.MAX_VALUE, minY=Integer.MAX_VALUE;

        for (Light l : lights) {
            if (l.position.x < minX) minX=l.position.x;
            if (l.position.y < minY) minY=l.position.y;
        }

        for (Light l : lights) {
            sky[l.position.y-minY][l.position.x-minX]='#';
        }

        for (int i = 0; i < sky.length; i++) {
            for (int j = 0; j < sky[i].length; j++) {
                System.out.print(sky[i][j]);
            }
            System.out.println();
        }
    }

    private static Point getDistance(Point p1, Point p2) {
        return new Point(Math.abs(p1.x-p2.x),
                         Math.abs(p1.y-p2.y));
    }

    private static List<Light> parseInput() throws FileNotFoundException {
        List<Light> rtn = new ArrayList<>();

        Scanner input = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2018/day10/input.txt"));
//        Scanner input = new Scanner(new File("C:/Users/jrdillingham/IdeaProjects/advent-of-code/src/y2018/day10/testInput.txt"));

        Pattern p = Pattern.compile("-*\\d+");


        while(input.hasNext()){
            Matcher m = p.matcher(input.nextLine());
            m.find();
            int x = Integer.parseInt(m.group());
            m.find();
            int y = Integer.parseInt(m.group());
            m.find();
            int vx = Integer.parseInt(m.group());
            m.find();
            int vy = Integer.parseInt(m.group());

            rtn.add(new Light(x,y,vx,vy));
        }

        return rtn;
    }
}
