package net.ranzer.aoc.y2015.day07.gates;

import net.ranzer.aoc.y2015.day07.Wire;

public class PassthroughGate extends Gate {

	private Wire a;

	public PassthroughGate(Wire a, Wire o){
		super(o);
		this.a = a;
		this.a.attachGate(this);
		update();
	}

	@Override
	public void update() {
		if(a.hasActiveSignal()) {
			o.setValue(a.getValue());
			o.setActiveSignal(true);
			System.out.println(this);
		} else {
			o.setActiveSignal(false);
		}
	}

	@Override
	public String toString() {
		return String.format("Running %s -> %s",a,o);
	}
}
