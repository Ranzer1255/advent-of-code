package y2019.day15;

import java.util.Map;

public class Maze {

	Node start;
	Node end;

	public Maze(Map<Loc, State> maze){

		for (Map.Entry<Loc,State> e :
				maze.entrySet()) {
			if (e.getValue().equals(State.BOT)){
				this.start = new Node(e.getKey());
			}

			if (e.getValue().equals(State.TARGET)){
				this.end = new Node(e.getKey());
			}
		}
	}

	class Node{
		Loc pos;
		Map<Direction, Node> neighbors;
		Map<Direction, Integer> distanceToNeighbor;

		Node(Loc pos){
			this.pos=pos;
		}


	}
}
