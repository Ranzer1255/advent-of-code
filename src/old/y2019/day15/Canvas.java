package y2019.day15;

import java.util.Map;
import java.util.Set;

class Canvas {

	static void displayCanvas(Map<Loc, State> canvas) {
		Loc lowestPoint = getLowest(canvas.keySet());
		Loc highestPoint = getHighest(canvas.keySet());

		drawLine(lowestPoint.x, highestPoint.x);
		for (int y = lowestPoint.y; y <= highestPoint.y; y++) {
			System.out.print('|');
			for (int x = lowestPoint.x; x <= highestPoint.x; x++) {
				State print = canvas.get(new Loc(x,y));
				if (print==null) print = State.UNKNOWN;
				System.out.print(print.draw);
			}
			System.out.println('|');
		}
		drawLine(lowestPoint.x, highestPoint.x);

		System.out.println(String.format("top left corner (%d,%d)\n" +
				"bottom left corner: (%d,%d)\n" +
				"size %dx%d",
				lowestPoint.x,lowestPoint.y,
				highestPoint.x, highestPoint.y,
				Math.abs(lowestPoint.x)+Math.abs(highestPoint.x),
				Math.abs(lowestPoint.y)+Math.abs(highestPoint.y)));
	}

	private static void drawLine(int start, int end) {
		System.out.print('*');
		for (int i = 0; i <= Math.abs(start)+Math.abs(end); i++) {
			System.out.print("-");
		}
		System.out.println('*');
	}

	private static Loc getHighest(Set<Loc> locs) {
		int x = Integer.MIN_VALUE;
		int y = Integer.MIN_VALUE;

		for (Loc l : locs) {
			if(l.x>x) x=l.x;
			if(l.y>y) y=l.y;
		}

		return new Loc(x,y);
	}

	private static Loc getLowest(Set<Loc> locs) {
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;

		for (Loc l : locs) {
			if(l.x<x) x=l.x;
			if(l.y<y) y=l.y;
		}

		return new Loc(x,y);
	}
}
