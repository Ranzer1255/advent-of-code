package y2019.day15;

enum State{
	UNKNOWN('.'),
	EMPTY(' '),
	WALL('#'),
	BOT('@'),
	TARGET('*');

	final char draw;

	State(char c){
		draw=c;
	}
}