package y2019.day15;

import java.util.*;

class RepairBot {

	private RepairBotProcessor rb = new RepairBotProcessor();
	private Map<Loc, State> world = new HashMap<>();
	Loc botPos = new Loc(0, 0);
	private Deque<Direction> moves = new LinkedList<>();
	Loc target;

	RepairBot() {
		world.put(botPos, State.BOT);
	}

	Map<Loc, State> getWorld() {
		if(target!=null) world.put(target,State.TARGET);
		return world;
	}

	/**
	 *
	 * @param d direction to move
	 * @return true if moved, false if hit wall
	 */
	boolean move(Direction d) {
		switch (rb.move(d)) {
			case TARGET:
				paintTarget(d);
			case MOVE:
				moves.push(d);
				moveInWorld(d);
				return true;
			case WALL:
				paintWall(d);
				return false;
			default:
				throw new IllegalStateException("Unexpected value: " + rb.move(d));
		}
	}

	private void paintTarget(Direction d) {
		this.target = botPos.getNeighbor(d);
	}

	private void moveInWorld(Direction d) {
		world.put(botPos, State.EMPTY);
		movePos(d);
		world.put(botPos,State.BOT);
	}

	void backtrack(int steps){

		for (int i = 0; i < steps; i++) {
			if (moves.isEmpty()) return;
			Direction d = Direction.reverse(moves.pop());
			rb.move(d);
			moveInWorld(d);
		}
	}

	private void movePos (Direction d) {
		switch (d) {
			case EAST:
				botPos = new Loc(botPos.x + 1, botPos.y);
				break;
			case WEST:
				botPos = new Loc(botPos.x - 1, botPos.y);
				break;
			case NORTH:
				botPos = new Loc(botPos.x, botPos.y - 1);
				break;
			case SOUTH:
				botPos = new Loc(botPos.x, botPos.y + 1);
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + d);
		}
	}

	private void paintWall(Direction direction) {
		switch (direction){
			case EAST:
				world.put(new Loc(botPos.x+1,botPos.y),State.WALL);
				break;
			case WEST:
				world.put(new Loc(botPos.x-1,botPos.y),State.WALL);
				break;
			case NORTH:
				world.put(new Loc(botPos.x,botPos.y-1),State.WALL);
				break;
			case SOUTH:
				world.put(new Loc(botPos.x,botPos.y+1),State.WALL);
				break;
		}
	}
}