package y2019.day15;

enum Response {
	WALL(0),
	MOVE(1),
	TARGET(2);
	final int code;
	Response(int code){
		this.code=code;
	}

	public static Response get(int code) {
		switch (code){
			case 0:
				return WALL;
			case 1:
				return MOVE;
			case 2:
				return TARGET;
			default:
				throw new IllegalStateException("Unexpected value: " + code);
		}
	}
}
