package net.ranzer.aoc.y2021.day05;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;
import net.ranzer.common.Line;
import net.ranzer.common.Loc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day05 extends Day {

	private ArrayList<Line> lines;
	private final Pattern pattern = Pattern.compile("(?<p1x>\\d*),(?<p1y>\\d*) -> (?<p2x>\\d*),(?<p2y>\\d*)");


	public Day05(){
		reset();
	}

	@Override
	public void part1() {

		List<Line> orthogonal = lines.stream().filter(Line::isOrthogonal).collect(Collectors.toList());

//		System.out.println(paintLines(orthogonal));

		Loc size = Line.maxSize(orthogonal);

		Map<Loc,Integer> points = new HashMap<>();

		for (int y = 0; y <= size.Y; y++) {
			for (int x = 0; x <= size.X; x++) {
				int intersections = 0;
				Loc point = new Loc(x,y);
				for(Line l : orthogonal){
					if(Line.onLineSegment(l,point)) intersections++;
				}

				points.put(point,intersections);
			}
		}

		System.out.println(points.values().stream().filter(p -> p > 1).count());

	}

	@Override
	public void part2() {

		Loc size = Line.maxSize(lines);

		Map<Loc,Integer> points = new HashMap<>();

		for (int y = 0; y <= size.Y; y++) {
			for (int x = 0; x <= size.X; x++) {
				int intersections = 0;
				Loc point = new Loc(x,y);
				for(Line l : lines){
					if(Line.onLineSegment(l,point)) intersections++;
				}

				points.put(point,intersections);
			}
		}

		System.out.println(points.values().stream().filter(p -> p > 1).count());

	}

	private String paintLines(List<Line> lines){
		StringBuilder rtn = new StringBuilder();

		Loc size = Line.maxSize(lines);

		for (int y = 0; y <= size.Y; y++) {
			for (int x = 0; x <= size.X; x++) {
				Loc p = new Loc(x,y);
				int painted = 0;
				for (Line l:lines){
					if(Line.onLineSegment(l,p)) {
						painted++;
					}
				}
				rtn.append(painted==0?".":painted);
//				rtn.append(" ");
			}
			rtn.append("\n");
		}

		return rtn.toString();
	}

	private List<Line> intersections(List<Line> lines ,Loc point){
		List<Line> rtn = new ArrayList<>();
		for (Line l :lines){
			if(Line.onLineSegment(l,point)) rtn.add(l);
		}
		return rtn;
	}

	public void reset(){
		Scanner input = Input.getScanner(2021,5);
		lines = new ArrayList<>();

		while (input.hasNextLine()){
			Matcher m = pattern.matcher(input.nextLine());
			m.matches();
			lines.add(
					new Line(
							new Loc(
									Integer.parseInt(m.group("p1x")),
									Integer.parseInt(m.group("p1y"))
							),
							new Loc(
									Integer.parseInt(m.group("p2x")),
									Integer.parseInt(m.group("p2y"))
							)));
		}
	}
}
