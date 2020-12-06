package net.ranzer.aoc.y2020.day06;

import net.ranzer.aoc.framework.Day;
import net.ranzer.aoc.framework.Input;

import java.util.*;

public class Day06 extends Day {


	List<Group> groups = new ArrayList<>();


	public Day06() {
		input = Input.getScanner(2020,6);

		List<String> groupStrings = new ArrayList<>();
		StringBuilder groupString = new StringBuilder();
		while (input.hasNext()){
			String s = input.nextLine();
			if(s.equals("")){
				groupStrings.add(groupString.substring(1));
				groupString = new StringBuilder();
			} else {
				groupString.append(":").append(s);
			}
		}
		groupStrings.add(groupString.substring(1));

		for (String s : groupStrings){
			groups.add(new Group(s));
		}
	}

	@Override
	public void part1() {

		int total = 0;

		for (Group g:groups){
			total += g.everyYes();
		}

		System.out.println(total);

	}

	@Override
	public void part2() {

		int total = 0;

		for (Group g:groups){
			total += g.everyoneQuestions();
		}

		System.out.println(total);

	}

	public static class Questionnaire {
		Set<Character> yesQuestions = new HashSet<>();

		public void addYes(char question){
			yesQuestions.add(question);
		}

		public int getTotal(){
			return yesQuestions.size();
		}

		public boolean contains(char c){
			return yesQuestions.contains(c);
		}
	}

	public static class Group {
		List<Questionnaire> questionnaires = new ArrayList<>();

		public Group(String s) {
			Questionnaire q = new Questionnaire();
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)==':'){
					questionnaires.add(q);
					q = new Questionnaire();
				}else{
					q.addYes(s.charAt(i));
				}
			}
			questionnaires.add(q);
		}

		public int everyoneQuestions(){
			int total = 0;
			Questionnaire lowCount = questionnaires.stream().min(Comparator.comparingInt(Questionnaire::getTotal)).get();

			nextChar: for (char c:lowCount.yesQuestions){
				for (Questionnaire q:questionnaires){
					if (!q.contains(c)) continue nextChar;
				}
				total++;
			}
			return total;
		}

		public int everyYes(){

			Questionnaire total = new Questionnaire();

			for (Questionnaire q:questionnaires){
				total.yesQuestions.addAll(q.yesQuestions);
			}

			return total.getTotal();
		}
	}
}
