package net.ranzer.aoc.y2015.day07;

import net.ranzer.aoc.y2015.day07.gates.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day7 {

	private static final File inputFile = new File("./src/net/ranzer/aoc/y2015/day07/input");
	private static final File testInput = new File("./src/net/ranzer/aoc/y2015/day07/testInput.txt");

	private static final Map<String, Wire> wires = new HashMap<>();

	public static void main(String[] args) throws FileNotFoundException {

		Pattern in       = Pattern.compile(GateType.INPUT.REGEX);
		Pattern straight = Pattern.compile(GateType.STRAIGHT.REGEX);
		Pattern not      = Pattern.compile(GateType.NOT.REGEX);
		Pattern and 	 = Pattern.compile(GateType.AND.REGEX);
		Pattern or 		 = Pattern.compile(GateType.OR.REGEX);
		Pattern ls  	 = Pattern.compile(GateType.LSHIFT.REGEX);
		Pattern rs 		 = Pattern.compile(GateType.RSHIFT.REGEX);

		Scanner input = new Scanner(inputFile);
		Map<Wire,Integer> inputs = new HashMap<>();

		while (input.hasNext()){
			String line = input.nextLine();

			//input check
			Matcher inMatcher = in.matcher(line);
			if(inMatcher.find()){
				System.out.println("found input string: "+line);

				int stringIn = Integer.parseInt(inMatcher.group("input"));

				String o = inMatcher.group("o");

				Wire wireO = getWire(o);

				wireO.setValue(stringIn);
				wireO.setActiveSignal(true);

				continue;

			}
			//straight check
			Matcher straightMatcher = straight.matcher(line);
			if(straightMatcher.find()){
				System.out.println("found straight string: "+line);

				String a = straightMatcher.group("input");
				String o = straightMatcher.group("o");

				Wire wireA = getWire(a);
				Wire wireO = getWire(o);

				new PassthroughGate(wireA,wireO);

				continue;

			}
			//Not check
			Matcher notMatcher = not.matcher(line);
			if(notMatcher.find()) {
				System.out.println("found Not string: "+line);
				String a = notMatcher.group("a");
				String o = notMatcher.group("o");

				Wire wireA = getWire(a);
				Wire wireO = getWire(o);

				new NotGate(wireA, wireO);

				continue;
			}

			//And check
			Matcher andMatcher = and.matcher(line);
			if(andMatcher.find()) {
				System.out.println("found AND string: "+line);

				String b = andMatcher.group("b");
				String o = andMatcher.group("o");

				Wire wireB = getWire(b);
				Wire wireO = getWire(o);

				Wire wireA;
				if(andMatcher.group("n") != null){

					wireA = new Wire("one");
					wireA.setValue(Integer.parseInt(andMatcher.group("n")));
					wireA.setActiveSignal(true);
//					new ConstAndGate(wireB,wireO);
				} else {

					String a = andMatcher.group("a");
					wireA = getWire(a);
				}
				new AndGate(wireA, wireB, wireO);


				continue;
			}			
			
			//OR check
			Matcher orMatcher = or.matcher(line);
			if(orMatcher.find()) {
				System.out.println("found OR string: "+line);
				String a = orMatcher.group("a");
				String b = orMatcher.group("b");
				String o = orMatcher.group("o");

				Wire wireA = getWire(a);
				Wire wireB = getWire(b);
				Wire wireO = getWire(o);

				new OrGate(wireA, wireB, wireO);

				continue;
			}
			//LS check
			Matcher lsMatcher = ls.matcher(line);
			if(lsMatcher.find()) {
				System.out.println("found LS string: "+line);
				String a = lsMatcher.group("a");
				int n = Integer.parseInt(lsMatcher.group("n"));
				String o = lsMatcher.group("o");

				Wire wireA = getWire(a);
				Wire wireO = getWire(o);

				new LShiftGate(wireA, n, wireO);
				continue;
			}
			//RS check
			Matcher rsMatcher = rs.matcher(line);
			if(rsMatcher.find()) {
				System.out.println("found RS string: "+line);
				String a = rsMatcher.group("a");
				int n = Integer.parseInt(rsMatcher.group("n"));
				String o = rsMatcher.group("o");

				Wire wireA = getWire(a);
				Wire wireO = getWire(o);

				new RShiftGate(wireA, n, wireO);
			}
		}
		int aValue = wires.get("a").getValue();
		wires.get("b").setValue(aValue);
		System.out.println(wires.get("a"));
	}

	private static Wire getWire(String wire) {
		if (wires.containsKey(wire)) return wires.get(wire);
		else {
			Wire w = new Wire(wire);
			wires.put(wire, w);
			return w;
		}
	}

}
