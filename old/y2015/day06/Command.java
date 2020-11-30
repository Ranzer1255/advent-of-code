package y2015.day06;

public enum Command {

	ON("^turn on"), OFF("^turn off"), TOGGLE("^toggle");
	public String pattern;
	
	Command(String pattern){
		this.pattern=pattern;
	}
}
