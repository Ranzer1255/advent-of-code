package y2019.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day8 {
	public static void main(String[] args) throws FileNotFoundException {
		List<Layer> layers = new ArrayList<>();
		Scanner input = new Scanner(new File("./src/y2019/day8/input.txt"));
		String in = input.nextLine();
		for (int i = 0; i < in.length(); i=i+(Layer.WIDTH*Layer.HEIGHT)) {
			int layerNumber = i/(Layer.HEIGHT *Layer.WIDTH);
			layers.add(new Layer());
			for (int j = 0; j < Layer.HEIGHT; j++) {
				for (int k = 0; k < Layer.WIDTH; k++) {
					int character = (Layer.WIDTH*j+k)+i;
					layers.get(layerNumber).put(k,j,Integer.parseInt(in.substring(character,character+1)));
				}
			}
		}

		int record = Integer.MAX_VALUE;
		Layer check = null;
		for (Layer l : layers) {
			int count = l.countInts(0);
			if (record > count){
				check = l;
				record = count;
			}
		}
		System.out.println(check.countInts(1)*check.countInts(2));


		Layer.Pixel[][] canvas = new Layer.Pixel[Layer.HEIGHT][Layer.WIDTH];
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[i].length; j++) {
				canvas[i][j] = Layer.Pixel.CLEAR;
			}
		}

		for (Layer l : layers) {
			for (int i = 0; i < canvas.length; i++) {
				for (int j = 0; j < canvas[i].length; j++) {
					if(canvas[i][j]== Layer.Pixel.CLEAR){
						canvas[i][j] = l.get(j,i);
					}
				}
			}
		}

		printCanvans(canvas);

	}

	private static void printCanvans(Layer.Pixel[][] canvas) {
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[i].length; j++) {
				System.out.print(canvas[i][j].color);
			}
			System.out.println();
		}
	}
}
