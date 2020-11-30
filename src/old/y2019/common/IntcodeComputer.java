package y2019.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class IntcodeComputer {
	private  Memory memory=new MemoryImpl();
	private  File program;
	private  int relativeBase=0;

	public IntcodeComputer(){}

	public IntcodeComputer(File program){
		this.program=program;
	}

	public  void setProgram(String file){
		program = new File(file);
	}

	public  void run() throws FileNotFoundException {

		initMemory();

		int instructionPointer = 0;
		boolean running = true;
		while (running){

			long a,b,o;

			//Decode optcode
			int instruction = (int) memory.recall(instructionPointer);
			int optcode = instruction % 100;

			switch (optcode){

				//Add
				case 1:

					a = setValue(instruction, instructionPointer+1, 0);
					b = setValue(instruction, instructionPointer+2, 1);
					o = getAddress(instruction, instructionPointer+3, 2);

					memory.set(o,a+b);
					instructionPointer+=4;
					break;

				// Multiply
				case 2:
					a = setValue(instruction, instructionPointer+1, 0);
					b = setValue(instruction, instructionPointer+2, 1);
					o = getAddress(instruction,instructionPointer+3, 2);
					memory.set(o,a*b);
					instructionPointer+=4;
					break;

				//Input
				case 3:
					Scanner s = new Scanner(System.in);
					System.out.print("input: ");
					long in = s.nextLong();
					o = getAddress(instruction,instructionPointer+1,0);
					memory.set(o,in);
					instructionPointer += 2;
					break;

				//Output
				case 4:
					o = setValue(instruction, instructionPointer+1, 0);
					System.out.println("output: "+o);
					instructionPointer += 2;
					break;

				//jump-if-true
				case 5:
					a = setValue(instruction,instructionPointer+1,0);
					if (a!=0){
						instructionPointer = (int)setValue(instruction,instructionPointer+2,1);
					} else {
						instructionPointer += 3;
					}
					break;

				//jump-if-false
				case 6:
					a = setValue(instruction,instructionPointer+1,0);
					if (a==0){
						instructionPointer = (int)setValue(instruction,instructionPointer+2,1);
					} else {
						instructionPointer += 3;
					}
					break;

				//less than
				case 7:
					a = setValue(instruction, instructionPointer+1, 0);
					b = setValue(instruction, instructionPointer+2, 1);
					o = getAddress(instruction,instructionPointer+3,2);

					if (a<b){
						memory.set(o,1L);
					} else {
						memory.set(o,0L);
					}

					instructionPointer+=4;
					break;

				//equals
				case 8:
					a = setValue(instruction, instructionPointer+1, 0);
					b = setValue(instruction, instructionPointer+2, 1);
					o = getAddress(instruction,instructionPointer+3,2);
					if (a==b){
						memory.set(o,1L);
					} else {
						memory.set(o,0L);
					}
					instructionPointer+=4;
					break;

				//Set Relative base
				case 9:
					a = setValue(instruction,instructionPointer+1,0);
					relativeBase += a;
					instructionPointer+=2;
					break;

				//Halt
				case 99:
					running = false;
					break;

				//Something went Wrong!!!!
				default:
					System.exit(-1);

			}
//			System.out.println(memory.toString());
		}
	}

	private long getAddress(int instruction, long paramIndex, int paramNum) {
		long rtn;
		if(getMode(instruction,paramNum)== ParamMode.RELATIVE){
			rtn = relativeBase + memory.recall(paramIndex);
		}else{
			rtn = memory.recall(paramIndex);
		}
		return rtn;
	}

	private  long setValue(int instruction, int paramIndex, int paramNum) {
		long rtn=0;
		switch (getMode(instruction,paramNum)){
			case IMMEDIATE:
				rtn = memory.recall(paramIndex);
				break;
			case RELATIVE:
				long offset = memory.recall(paramIndex);
				rtn = memory.recall(relativeBase + offset);
				break;
			case POSITION:
				rtn = memory.recall(memory.recall(paramIndex));
				break;
		}
		return rtn;
	}

	private  ParamMode getMode(int instruction, int paramNum) {
		int pramvars  = instruction /100;
		int mode = (pramvars / (int)(Math.pow(10,paramNum))) % 10;


		for (ParamMode p:ParamMode.values()) {
			if (p.CODE==mode) return p;
		}
		return ParamMode.POSITION;
	}

	private  void initMemory() {
		memory.initMemory(program);
	}

	private enum ParamMode{
		POSITION(0),
		IMMEDIATE(1),
		RELATIVE(2);


		public final int CODE;

		ParamMode(int code){
			this.CODE = code;
		}
	}

}
