package y2015.day07;

import y2015.day07.gates.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day7 {

	static File input = new File("./src/y2015/day07/input.txt");
//	private static File testInput = new File("./src/y2015/day07/testInput.txt");

	private static Map<String, Wire> wires = new HashMap<>();

	public static void main(String[] args) throws FileNotFoundException {

		String inputRegex = "^(?<input>\\d+) -> (?<o>[a-z]+)$";
		Pattern in = Pattern.compile(inputRegex);
		String straightRegex = "^(?<input>[a-z]+) -> (?<o>[a-z]+)$";
		Pattern straight = Pattern.compile(straightRegex);
		String notRegex = "^NOT (?<a>[a-z]+) -> (?<o>[a-z]+)$";
		Pattern not = Pattern.compile(notRegex);
		String andRegex = "^(?:(?<n>\\d+)|(?<a>[a-z]+)) AND (?<b>[a-z]+) -> (?<o>[a-z]+)$";
		Pattern and = Pattern.compile(andRegex);
		String orRegex = "^(?<a>[a-z]+) OR (?<b>[a-z]+) -> (?<o>[a-z]+)$";
		Pattern or = Pattern.compile(orRegex);
		String lShiftRegex = "^(?<a>[a-z]+) LSHIFT (?<n>\\d+) -> (?<o>[a-z]+)$";
		Pattern ls = Pattern.compile(lShiftRegex);
		String rShiftRegex = "^(?<a>[a-z]+) RSHIFT (?<n>\\d+) -> (?<o>[a-z]+)$";
		Pattern rs = Pattern.compile(rShiftRegex);


		Scanner input = new Scanner(Day7.input);
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

//		System.out.println(wires.get("a"));
		for (Wire w :
				wires.values()) {
			System.out.println(w);
		}

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
