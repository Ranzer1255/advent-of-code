package y2016.day08;


/**
 * To get past the door, you first swipe a keycard 
 * (no problem; there was one on a nearby desk).
 * Then, it displays a code on a little screen, 
 * and you type that code on a keypad. Then, presumably, the door unlocks.
 * 
 * Unfortunately, the screen has been smashed. After a few minutes, 
 * you've taken everything apart and figured out how it works. 
 * Now you just have to work out what the screen would have displayed.
 * 
 * The magnetic strip on the card you swiped encodes 
 * a series of instructions for the screen; these instructions 
 * are your puzzle input. The screen is 50 pixels wide and 6 pixels tall, 
 * all of which start off, and is capable of three somewhat peculiar operations:
 * 
 * @author jrdillingham
 *
 */
public class Display {
	
	
	boolean[][] screen = new boolean[6][50];//[y][x] || [b][a]
//	boolean[][] screen = new boolean[3][7];//[y][x] || [b][a]
	
	/**
	 * rect AxB turns on all of 
	 * the pixels in a rectangle at 
	 * the top-left of the screen 
	 * which is A wide and B tall.
	 * @param a
	 * @param b
	 */
	public void rect(int a, int b){
//		System.out.println(String.format("rect %dx%d", a,b));
		for (int i=0;i<a;i++) {
			for(int j=0;j<b;j++){
				screen[j][i]=true;
			}
		}
//		System.out.println(this.getDisplay());
	}
	
	/**
	 * rotate row y=row by shift 
	 * 
	 * shifts all of the pixels in row A
	 * (0 is the top row) right by B pixels.
	 * Pixels that would fall off the right end appear
	 * at the left end of the row.
	 * 
	 * @param row
	 * @param shift
	 */
	public void rotateRow(int row, int shift){
//		System.out.println(String.format("rotate row y=%d by %d", row, shift));
		//TODO
		for(int i=0;i<shift;i++){
			boolean bs = screen[row][screen[row].length-1];
			for (int j = screen[row].length-1; j >=0; j--) {
				if(j-1<0){
					screen[row][j]=bs;
					continue;
				}
				screen[row][j]=screen[row][j-1];
			}
		}
//		System.out.println(this.getDisplay());
	}
	
	/**
	 * rotate column x=col by shift
	 * 
	 * shifts all of the pixels in column col 
	 * (0 is the left column) down by shift pixels.
	 * Pixels that would fall off the bottom appear at the top of the column.
	 * 
	 * @param col
	 * @param shift
	 */
	public void rotateCol(int col, int shift){
//		System.out.println(String.format("rotate column x=%d by %d", col,shift));
		//TODO
		for(int i=0;i<shift;i++){
			boolean bs = screen[screen.length-1][col];
			for (int j = screen.length-1; j >=0; j--) {
				if(j-1<0){
					screen[j][col]=bs;
					continue;
				}
				screen[j][col]=screen[j-1][col];
			}
		}
//		System.out.println(this.getDisplay());
	}
	
	/**
	 * 0,0 is top right corner
	 * 
	 * @return
	 */
	public String getDisplay(){
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				if(screen[i][j]) sb.append('#');
				else sb.append('.');
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	
	
	public int getLights(){
		int rtn = 0;
		
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				if (screen[i][j]) rtn++;
			}
		}
		return rtn;
	}

}
