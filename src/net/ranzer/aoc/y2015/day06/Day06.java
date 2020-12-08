package net.ranzer.aoc.y2015.day06;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day06 extends Day {

	Light[][] grid = new Light[1000][1000];
	private final List<String> instructions = new ArrayList<>();

	public Day06() {
		inputScanner = Input.getScanner(2015,6);

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j]=new Light();
			}
		}

		while(inputScanner.hasNext()){
			instructions.add(inputScanner.nextLine());
		}
		inputScanner.close();
	}

	@Override
	public void part1() {

		StringBuilder cmdPtnBffer = new StringBuilder();
		for (Command command : Command.values()) {
			cmdPtnBffer.append(String.format("|(?<%s>%s)", command.name(), command.pattern));
		}
		Pattern cmdPatterns = Pattern.compile(cmdPtnBffer.substring(1));
		Pattern rectPattern = Pattern.compile("(?<x1>\\d+),(?<y1>\\d+) through (?<x2>\\d+),(?<y2>\\d+)");
		
		for (String instruction : instructions){
			Command cmd = null;
			Matcher cmdMatch = cmdPatterns.matcher(instruction);
			cmdMatch.find();
			for (Command command : Command.values()) {
				if(cmdMatch.group(command.name())!=null){
					cmd = command;
					break;
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
		for (Light[] lights : grid) {
			for (Light light : lights) {
				count += light.getLit();
			}
		}
		System.out.println(count);
	}
	
	private void processInstruction(Command cmd, Rect rect) {

		for (int y = rect.Y1; y < rect.Y2; y++) {
			for (int x = rect.X1; x < rect.X2; x++) {
				switch (cmd){
					case ON:
						grid[x][y].turnOn();
						break;
					case OFF:
						grid[x][y].turnOff();
						break;
					case TOGGLE:
						grid[x][y].toggle();
						break;
				}
			}

		}
		//WHY IN THE **HELL** DID I THINK THIS WAS A GOOD IDEA!
		//I SHAVED OFF 320 MILLISECONDS BY DOING IT THE ABOVE WAY!
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[i].length; j++) {
//				if(i>=rect.Y1&&i<=rect.Y2&&j>=rect.X1&&j<=rect.X2){
//					switch (cmd){
//					case ON:
//						grid[i][j].turnOn();
//						break;
//					case OFF:
//						grid[i][j].turnOff();
//						break;
//					case TOGGLE:
//						grid[i][j].toggle();
//						break;
//					}
//				}
//			}
//		}
		
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

	public enum Command {

		ON("^turn on"), OFF("^turn off"), TOGGLE("^toggle");
		public String pattern;

		Command(String pattern){
			this.pattern=pattern;
		}
	}
}
