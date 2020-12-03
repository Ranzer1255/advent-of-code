package net.ranzer.aoc.y2015.day07.gates;

import net.ranzer.aoc.y2015.day07.Wire;

public abstract class Gate {

	Wire o;

	public Gate(Wire o) {
		this.o = o;
	}

	public abstract void update();

//	public abstract boolean hasActiveSignal();
}
