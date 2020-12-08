package net.ranzer.aoc.y2019.day02;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;

public class Day02 extends Day {
	ArrayList<Integer> initState;
	ArrayList<Integer> memory;

	public Day02() {
		inputScanner = Input.getScanner(2019,2);
		inputScanner.useDelimiter(",");

		initState = new ArrayList<>();
		while (inputScanner.hasNext()){
			initState.add(inputScanner.nextInt());
		}
		inputScanner.close();
	}

	private void initialize() {

		memory = new ArrayList<>(initState);


	}

	@Override
	public void part1() {

		System.out.println(runIntCodeMachine(10,2));

	}

	@Override
	public void part2() {

		int target = 19690720;

		for (int i = 0; i < 99; i++) {
			for (int j = 0; j < 99; j++) {
				int test = runIntCodeMachine(i,j);
				if (test==target){
					System.out.printf("%d%d\n",i,j);
				}
			}
		}

	}

	private int runIntCodeMachine(int noun, int verb){
		initialize();

		memory.set(1,noun);
		memory.set(2,verb);

		int pointer = 0;

		boolean run = true;
		while(run) {
			int opcode = memory.get(pointer);
			switch (opcode){
				case 1: {//add
					int a = memory.get(memory.get(pointer + 1));//value
					int b = memory.get(memory.get(pointer + 2));//value
					int o = memory.get(pointer + 3);//address
					memory.set(o,a+b);
					pointer+=4;
					break;
				}
				case 2:{ //mult
					int a = memory.get(memory.get(pointer + 1));//value
					int b = memory.get(memory.get(pointer + 2));//value
					int o = memory.get(pointer + 3);//address
					memory.set(o,a*b);
					pointer+=4;
					break;
				}
				case 99://halt
					return memory.get(0);
				default://oops!
					System.out.println("CRASH!!!");
					System.exit(opcode);
			}
		}
		return -1;
	}


}
