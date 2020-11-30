package y2019.day8;

import java.awt.*;
import java.util.Arrays;

public class Layer {
	static final int WIDTH = 25;
	static final int HEIGHT = 6;

	private Pixel[][] layer = new Pixel[HEIGHT][WIDTH];

	void put(int x, int y, int val){
		layer[y][x] = Pixel.get(val);
	}
	public Pixel get(int x, int y){
		return layer[y][x];
	}

	@Override
	public String toString() {
		return Arrays.deepToString(layer);
	}

	int countInts(int count){
		int rtn = 0;

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if(layer[i][j].code == count) rtn++;
			}
		}

		return rtn;
	}

	enum Pixel{
		BLACK(0, ' '),
		WHITE(1, '@'),
		CLEAR(2, ' ');

		public final int code;
		public final char color;
		Pixel(int code, char color){
			this.code=code;
			this.color = color;
		}

		public static Pixel get(int val) {
			switch (val){
				case 0:
					return BLACK;
				case 1:
					return WHITE;
				case 2:
					return CLEAR;
				default:
					throw new IllegalStateException("Unexpected value: " + val);
			}
		}
	}
}
