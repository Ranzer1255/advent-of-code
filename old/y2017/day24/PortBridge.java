package y2017.day24;

import java.io.File;

public class PortBridge {
	
	public static File input = new File("C:/Users/jrdillingham.MABANKISD/Programing/workspace/adventofcode/src/y2017/day24/day24input.txt");

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Connector{
		public final int PORT1;
		public final int PORT2;
		public final int sum;
		
		public Connector(int port1, int port2) {
			PORT1=port1;
			PORT2=port2;
			sum=PORT1+PORT2;
		}
	}

}
