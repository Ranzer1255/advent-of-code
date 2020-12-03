package net.ranzer.aoc.y2015.day07;

import java.util.regex.Pattern;

public enum GateType{

	//language=RegExp
	INPUT("^(?<input>\\d+) -> (?<o>[a-z]+)$"),

	//language=RegExp
	STRAIGHT("^(?<input>[a-z]+) -> (?<o>[a-z]+)$"),

	//language=RegExp
	NOT("^NOT (?<a>[a-z]+) -> (?<o>[a-z]+)$"),

	//language=RegExp
	AND("^(?:(?<n>\\d+)|(?<a>[a-z]+)) AND (?<b>[a-z]+) -> (?<o>[a-z]+)$"),

	//language=RegExp
	OR("^(?<a>[a-z]+) OR (?<b>[a-z]+) -> (?<o>[a-z]+)$"),

	//language=RegExp
	LSHIFT("^(?<a>[a-z]+) LSHIFT (?<n>\\d+) -> (?<o>[a-z]+)$"),

	//language=RegExp
	RSHIFT("^(?<a>[a-z]+) RSHIFT (?<n>\\d+) -> (?<o>[a-z]+)$");

	public final String REGEX;
	GateType(String regex) {
		this.REGEX = regex;
	}
}
