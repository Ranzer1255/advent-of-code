package net.ranzer.aoc.framework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Day {

	protected File input_file;
	protected List<String> examples = new ArrayList<>();
	protected Scanner input;


	public abstract void part1();
	public abstract void part2();
}
