package y2015.day07;

import y2015.day07.gates.Gate;

import java.util.ArrayList;
import java.util.List;

public class Wire {

	List<Gate> attachedGates = new ArrayList<>();

	private String name;
	private int value;

	public Wire(String name){
		this.name=name;
	}

	public int getValue() {
		return value & 0xffff;
	}

	public void setValue(int value) {
		this.value = value & 0xffff;
		updateAttachedGates();
	}

	private void updateAttachedGates() {
		for (Gate g :
				attachedGates) {
			g.update();
		}
	}

	public String getName() {
		return name;
	}

	public void attachGate(Gate g){
		attachedGates.add(g);
	}

	@Override
	public String toString() {
		return String.format("Wire %s: %d",name,getValue());
	}
}
