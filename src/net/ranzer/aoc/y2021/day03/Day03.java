package net.ranzer.aoc.y2021.day03;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;
import net.ranzer.aoc.y2018.day07.Worker;

import java.util.ArrayList;
import java.util.Scanner;

public class Day03 extends Day {

	ArrayList<String> reports = new ArrayList<>();

	public Day03(){
		Scanner in = Input.getScanner(2021,3);

		while (in.hasNext()){
			reports.add(in.next());
		}
	}


	@Override
	public void part1() {
		StringBuilder gamma= new StringBuilder();
		StringBuilder epsilon = new StringBuilder();
		for(int i = 0; i<reports.get(0).length(); i++) {
			int ones = 0;
			int zeros = 0;
			for (String s : reports) {
				if (s.charAt(i)=='1') ones++;
				else zeros++;
			}
			gamma.append(ones > zeros ? '1' : '0');
		}

		for (int i = 0; i < gamma.length(); i++) {
			epsilon.append(gamma.charAt(i)=='1'?'0':'1');
		}

		System.out.printf("gamma: %s\n",gamma);
		System.out.printf("epsilon: %s\n",epsilon);

		int gamma_number = Integer.parseInt(gamma.toString(),2);
		int epsilon_number = Integer.parseInt(epsilon.toString(),2);

		System.out.printf("gamma: %d\n",gamma_number);
		System.out.printf("epsilon: %d\n",epsilon_number);

		System.out.printf("Part 1 result: %d\n", gamma_number*epsilon_number);
	}

	@Override
	public void part2() {

		ArrayList<String> workingSet = new ArrayList<>(reports);

		int index=0;
		while(workingSet.size()>1) {
			int ones = 0;
			int zeros = 0;
			char toMatch = ' ';
			for (String s : workingSet) {
				if (s.charAt(index) == '1') ones++;
				else zeros++;
			}

			toMatch = ones >= zeros ? '1' : '0';
			for (int i = 0; i < workingSet.size(); i++) {
				if(workingSet.get(i).charAt(index)!=toMatch){
					workingSet.remove(i--);
				}
			}
//			System.out.printf("round %d:\nones: %d\nzeros: %d\nmatching on %c\n%d remaining\n",
//					index,ones,zeros,toMatch,workingSet.size());
			index++;
		}

		String O2 = workingSet.get(0);
		System.out.println(O2);

		index=0;
		workingSet = new ArrayList<>(reports);
		while(workingSet.size()>1) {
			int ones = 0;
			int zeros = 0;
			char toMatch = ' ';
			for (String s : workingSet) {
				if (s.charAt(index) == '1') ones++;
				else zeros++;
			}

			toMatch = ones >= zeros ? '0' : '1';
			for (int i = 0; i < workingSet.size(); i++) {
				if(workingSet.get(i).charAt(index)!=toMatch){
					workingSet.remove(i--);
				}
			}
			System.out.printf("round %d:\nones: %d\nzeros: %d\nmatching on %c\n%d remaining\n",
					index,ones,zeros,toMatch,workingSet.size());
			index++;
		}
		String CO2 = workingSet.get(0);

		System.out.printf("result = %d\n", Integer.parseInt(O2,2)*Integer.parseInt(CO2,2));

	}
}
