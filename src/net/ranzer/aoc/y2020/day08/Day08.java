package net.ranzer.aoc.y2020.day08;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day08 extends Day {

	List<String> instructionStrings = new ArrayList<>();
	List<Instruction> instructions = new ArrayList<>();

	public Day08() {
		inputScanner = Input.getScanner(2020,8);
		while (inputScanner.hasNext()){
			String line = inputScanner.nextLine();
			instructionStrings.add(line);
			instructions.add(new Instruction(line));
		}
		inputScanner.close();
	}

	@Override
	public void part1() {
		Set<Integer> previousInstructions=new HashSet<>();
		int counter = 0;
		int acc=0;
		while (true) {
			String instruction = instructionStrings.get(counter);
			String op = instruction.substring(0,3);
			switch (op) {
				case "nop":
					counter++;
					break;
				case "acc":
					counter++;
					acc += Integer.parseInt(instruction.substring(4));
					break;
				case "jmp":
					counter += Integer.parseInt(instruction.substring(4));
					break;
				default:
					System.out.println("um WAT?!");
					System.exit(-1);
			}
			if(!previousInstructions.add(counter)){
				break;
			}
		}
		System.out.println(acc);
	}

	@Override
	public void part2() {
	  /*run through the list and find an instruction that targets the "stop condition" as is
		if there is an instruction, make that the new target and scan again.
		if nothing, unchanged, hits the target, find one that, if changed, will hit the target
	  */

		int goalCounter = instructions.size();
		boolean found = false;
		for (int i = 0; i < instructions.size(); i++) {
			Instruction inst = instructions.get(i);
			switch (inst.cmd){
				case JMP:
					if(i+inst.arg==goalCounter){ //we found one that leads to the target
						System.out.println("found one! new goal: "+i);
						System.out.printf("instruction %d: %s\n",i,instructions.get(i));
						goalCounter=i; //mark the new target to be this one
						i=-1; //reset the loop
						found = true;
						continue;
					}
					break;
				case ACC:
				case NOP:
					if(i+1==goalCounter){ //we found one that leads to the target
						System.out.println("found one! new goal: "+i);
						System.out.printf("instruction %d: %s\n",i,instructions.get(i));
						goalCounter=i; //mark the new target to be this one
						i=-1; //reset the loop
						found = true;
						continue;
					}
					break;
			}
		}

		//safety net to CYA
		if(!found) {
			System.out.println("we didn't find one HCF!");
			System.exit(-1);
		}

		//fixing the loop
		System.out.println("fixing the loop");
		loop:for (int i = 0; i < instructions.size(); i++) {
			Instruction inst = instructions.get(i);
			switch (inst.cmd){
				case ACC:
					continue;
				case NOP:
					if(i+inst.arg==goalCounter) { //we found it!
						System.out.printf("instruction %d: %s\n",i,instructions.get(i));
						instructions.get(i).cmd= Instruction.Command.JMP; //fix the command
						break loop;
					}
					continue;
				case JMP:
					if(i+1==goalCounter){ //we found one that leads to the target
						System.out.printf("instruction %d: %s\n",i,instructions.get(i));
						instructions.get(i).cmd= Instruction.Command.NOP; //fix the command
						System.out.printf("fixed instruction %d: %s\n",i,instructions.get(i));
						break loop;
					}
			}
		}

		int acc=0;
		int counter=0;
		while (true) {
			Instruction instruction = instructions.get(counter);
			System.out.printf("instruction %d: %s\n",counter,instructions.get(counter));
			switch (instruction.cmd) {
				case NOP:
					counter++;
					break;
				case ACC:
					counter++;
					acc += instruction.arg;
					break;
				case JMP:
					counter += instruction.arg;
					break;
				default:
					System.out.println("um WAT?!");
					System.exit(-1);
			}
			if (counter>=instructions.size()){
				break;
			}
		}
		System.out.println(acc);


	}

	public static class Instruction{
		int arg;
		Command cmd;

		public Instruction(String instruction){
			cmd = parseCommand(instruction.substring(0,3));
			arg = Integer.parseInt(instruction.substring(4));
		}

		private Command parseCommand(String substring) {
			switch (substring){
				case "nop": return Command.NOP;
				case "acc": return Command.ACC;
				case "jmp": return Command.JMP;
				default: return null;
			}
		}

		@Override
		public String toString() {
			return String.format("%s %d",cmd,arg);
		}

		public enum Command{
			ACC,JMP,NOP
		}
	}
}
