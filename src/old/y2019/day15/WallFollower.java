package y2019.day15;

class WallFollower extends RepairBot {

	private Direction facing = Direction.SOUTH;

	void explore(){

		while (exploring()){
			//turn right
			facing = Direction.right(facing);
			//move forward
			moveForward();
		}
		Canvas.displayCanvas(this.getWorld());
		System.out.println("Target: "+target);

	}

	/**
	 * @return true if at origin and target has been found
	 */
	private boolean exploring() {
		return !(botPos.equals(0,0) && this.target!=null);
	}

	private void moveForward(){
		if(!move(facing)){
			//turn left
			facing = Direction.left(facing);
			moveForward();
		}
	}
}
