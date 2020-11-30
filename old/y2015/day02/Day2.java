package y2015.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {
	
	static File input = new File(System.getProperty("user.dir")+"/src/y2015/day02/day2Input.txt");
	static Pattern p = Pattern.compile("(?<h>\\d+)x(?<w>\\d+)x(?<l>\\d+)");

	public static void main(String[] args) {
		
		List<Present> pile = new ArrayList<>();

		try(Scanner read = new Scanner(input)){
			while (read.hasNextLine()){
				Matcher m = p.matcher(read.nextLine());
				m.find();
				Present pres = new Present(m.group("h"), m.group("w"), m.group("l"));
				pile.add(pres);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int totalPaper=0;
		int totalRibon=0;
		for (Present present : pile) {
			totalPaper+=present.surfaceArea+present.smallSideArea;
			totalRibon+=present.smallSideParemiter+present.volume;
		}
		
		System.out.println(totalPaper);
		System.out.println(totalRibon);
		
		
	}
	
	public static class Present{
		public final int H,W,L;
		public final int volume;
		public final int surfaceArea;
		public final int smallSideArea;
		public final int smallSideParemiter;
		
		public Present(int hight, int width, int length){
			H=hight;
			W=width;
			L=length;
			
			volume = H*W*L;
			surfaceArea = (2*L*W)+(2*W*H)+(2*H*L);
			smallSideArea = Math.min(H*L, Math.min(H*W,L*W));
			smallSideParemiter = Math.min(2*H+2*L, Math.min(2*W+2*H, 2*W+2*L));
		}
		
		public Present(String h, String w, String l){
			this(Integer.parseInt(h),Integer.parseInt(w),Integer.parseInt(l));
		}
		
	}

}
