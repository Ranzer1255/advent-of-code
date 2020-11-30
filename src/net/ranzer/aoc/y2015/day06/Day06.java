package net.ranzer.aoc.y2015.day06;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day06 extends Day {

	public Day06() {
		input = Input.getScanner(2015,6);
	}

	Light[][] grid = new Light[1000][1000];
	
	public static void main(String[] args) throws FileNotFoundException {
	
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j]=new Light();
			}
		}
		StringBuilder cmdPtnBffer = new StringBuilder();
		for (Command command : Command.values()) {
			cmdPtnBffer.append(String.format("|(?<%s>%s)", command.name(), command.pattern));
		}
		Pattern cmdPatterns = Pattern.compile(cmdPtnBffer.substring(1));
		Pattern rectPattern = Pattern.compile("(?<x1>\\d+),(?<y1>\\d+) through (?<x2>\\d+),(?<y2>\\d+)");
		Scanner read = new Scanner(input);
		
		while (read.hasNextLine()){
			String instruction = read.nextLine();
			Command cmd = null;
			Matcher cmdMatch = cmdPatterns.matcher(instruction);
			cmdMatch.find();
			findcmd: for (Command command : Command.values()) {
				if(cmdMatch.group(command.name())!=null){
					cmd = command;
					break findcmd;
				}
			}
			
			Matcher rectMatcher = rectPattern.matcher(instruction);
			rectMatcher.find();
			Rect rect = new Rect(
					Integer.parseInt(rectMatcher.group("x1")),
					Integer.parseInt(rectMatcher.group("y1")),
					Integer.parseInt(rectMatcher.group("x2")),
					Integer.parseInt(rectMatcher.group("y2"))
			);
			
			processInstruction(cmd,rect);
		}
		
		
		int count=0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				count+=grid[i][j].getLit();
			}			
		}
		System.out.println(count);
		read.close();
	}
	
	private static void processInstruction(Command cmd, Rect rect) {
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(i>=rect.Y1&&i<=rect.Y2&&j>=rect.X1&&j<=rect.X2){
					switch (cmd){
					case ON:
						grid[i][j].turnOn();
						break;
					case OFF:
						grid[i][j].turnOff();
						break;
					case TOGGLE:
						grid[i][j].toggle();
						break;
					}
				}
			}
		}
		
	}

	@Override
	public void part1() {

	}

	@Override
	public void part2() {

	}

	static class Rect{
		public final int X1,Y1,X2,Y2;
		public Rect(int x1,int y1, int x2,int y2){
			X1=x1; Y1=y1; X2=x2; Y2=y2;
		}
	}
	static class Light{
		private int lit = 0;
		public int getLit(){return lit;}
		public void turnOn(){lit+=1;}
		public void turnOff() {lit=Math.max(0, lit-1);}
		public void toggle(){lit+=2;}
	}
}
