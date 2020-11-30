package y2016.day03;

public class Triangle {
	
	public final boolean VALID;
	public final int A,B,C;
	
	public Triangle(int a, int b, int c){
		A=a; B=b; C=c;
		
		VALID=((A+B)>C&&(A+C)>B&&(B+C)>A);
	}

//	public Triangle(String sides){
//		String[] s = sides.split("\\s");
//		this(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
//	}

}
