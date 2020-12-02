package net.ranzer.aoc.y2020.day02;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02 extends Day {

	Pattern parser = Pattern.compile("(?<low>\\d+)-(?<high>\\d+) (?<char>[a-zA-Z]): (?<password>[a-zA-Z]+)");

	List<Password> passwords = new ArrayList<>();

	public Day02() {
		input = Input.getScanner(2020,2);

		while(input.hasNext()){
			Matcher m = parser.matcher(input.nextLine());

			if(m.find()){
				int  low  = Integer.parseInt(m.group("low"));
				int  high = Integer.parseInt(m.group("high"));

				char rule = m.group("char").charAt(0);

				String pass = m.group("password");

				passwords.add(new Password(low,high,rule,pass));
			}
		}

	}

	@Override
	public void part1() {

		int count = 0;
		for (Password p:passwords){
			if (p.part1rule()) count++;
		}

		System.out.println(count);
	}

	@Override
	public void part2() {

		int count = 0;
		for (Password p:passwords){
			if (p.part2rule()) count++;
		}

		System.out.println(count);

	}

	private class Password{

		String password;
		Rule rule;


		public Password(int low, int high, char rule, String password) {

			this.rule = new Rule(low,high,rule);
			this.password = password;

		}

		public boolean part1rule(){
			int count = 0;
			for (int i = 0; i < password.length(); i++) {
				if(password.charAt(i)==rule.rule){
					count++;
				}
			}

			return (rule.low<=count && count<=rule.high);
		}

		public boolean part2rule(){
			if(password.charAt(rule.low-1)==rule.rule&&password.charAt(rule.high-1)!=rule.rule){
				return true;
			} else return password.charAt(rule.high-1) == rule.rule && password.charAt(rule.low-1) != rule.rule;
		}

		private class Rule{

			int low,high;
			char rule;

			public Rule(int low, int high, char rule) {
				this.low = low;
				this.high = high;
				this.rule = rule;
			}
		}
	}
}
