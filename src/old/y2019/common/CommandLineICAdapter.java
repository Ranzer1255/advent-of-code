package y2019.common;

import java.io.File;
import java.util.Scanner;

public class CommandLineICAdapter {

	private IntcodeComputer computer = new IntcodeComputer();

	public void setProgram(String program){
		computer.setProgram(program);
	}
	public void setProgram(File program){
		computer.setProgram(program);
	}

	public void run(){

		running:while (true) {
			switch (computer.run()){
				case Halted:
					break running;
				case inputNeeded:
					System.out.print("input: ");
					Scanner s = new Scanner(System.in);
					computer.addInput(s.nextLong());
			}
		}

		System.out.println("output: ");
		for (long l:computer.getOut()) {
			System.out.println(l);
		}
	}
}
