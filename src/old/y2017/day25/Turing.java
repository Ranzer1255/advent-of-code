package y2017.day25;

import java.util.ArrayList;

public class Turing {
	
	public static State A = new State(){
		@Override
		public void value0() {
			write(1);
			move(Direction.right);
			set(B);
		}
		@Override
		public void value1() {
			write(0);
			move(Direction.right);
			set(C);
		}
	};
	public static State B = new State(){
		@Override
		public void value0() {
			write(0);
			move(Direction.left);
			set(A);
		}
		@Override
		public void value1() {
			write(0);
			move(Direction.right);
			set(D);
		}
	};
	public static State C = new State(){
		@Override
		public void value0() {
			write(1);
			move(Direction.right);
			set(D);
		}
		@Override
		public void value1() {
			write(1);
			move(Direction.right);
			set(A);
		}
	};
	public static State D = new State(){
		@Override
		public void value0() {
			write(1);
			move(Direction.left);
			set(E);
		}
		@Override
		public void value1() {
			write(0);
			move(Direction.left);
			set(D);
		}
	};
	public static State E = new State(){
		@Override
		public void value0() {
			write(1);
			move(Direction.right);
			set(F);
		}
		@Override
		public void value1() {
			write(1);
			move(Direction.left);
			set(B);
		}
	};
	public static State F = new State(){
		@Override
		public void value0() {
			write(1);
			move(Direction.right);
			set(A);
		}
		@Override
		public void value1() {
			write(1);
			move(Direction.right);
			set(E);
		}
	};
	
	public static final int STEPS = 12368930;
	
	public static ArrayList<Integer> ribbon = new ArrayList<>();
	public static int head = 0;
	public static State state = A;
	
	public static void main(String[] args) {
		ribbon.add(0);
		for (int i = 0; i < STEPS; i++) {
			switch (ribbon.get(head)){
			case 0:
				state.value0();
				break;
			case 1:
				state.value1();
				break;
			}	
		}
		int count=0;
		for (Integer i : ribbon) {
			if (i.intValue()==1) count++;
		}
		System.out.println(count);
	}
	
	private static void write(int bit){
		ribbon.set(head, bit);
	}
	
	private static void move(Direction d){
		switch (d) {
		case left:
			head--;
			if(head<0){
				head=0;
				ribbon.add(0, 0);
			}
			break;
		case right:
			head++;
			if(head==ribbon.size()){
				ribbon.add(0);
			}
			break;
		}
	}
	
	private static void set(State s){
		state = s;
	}
	
	enum Direction{
		right, left;
	}

}
