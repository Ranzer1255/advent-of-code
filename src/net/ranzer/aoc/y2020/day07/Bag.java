package net.ranzer.aoc.y2020.day07;

import java.util.*;

public class Bag {
		String color;
		Map<Bag, Integer> contents = new HashMap<>();
		Set<Bag> containedIn = new HashSet<>();

		public Bag(String color) {
			this.color = color;
		}

		public void addBag(Bag b, int number) {
			contents.put(b, number);
			b.isIn(this);
		}

		public void isIn(Bag b) {
			containedIn.add(b);
		}

		public Set<Bag> allOuterBags(){
			Set<Bag> rtn = new HashSet<>(containedIn);

			containedIn.forEach((b)->rtn.addAll(b.allOuterBags()));

			return rtn;
		}

		public int innerBagCount(){
			int rtn = contents.values().stream().reduce(0,Integer::sum);

			for (Bag b:contents.keySet()){
				rtn += b.innerBagCount()*contents.get(b);
			}

			return rtn;
		}

		@Override
		public String toString() {
			return String.format("%s bag", color);
		}
}
