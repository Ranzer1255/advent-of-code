package net.ranzer.aoc.y2015.day07.gates;

import net.ranzer.aoc.y2015.day07.Wire;

public class NotGate extends Gate {
	Wire a;

	public NotGate(Wire a, Wire o){
		super(o);
		this.a = a;
		this.a.attachGate(this);

		update();

	}

	@Override
	public void update() {
		if(a.hasActiveSignal()) {
			o.setValue(~a.getValue());
			System.out.println(this);
			o.setActiveSignal(true);
		} else {
			o.setActiveSignal(false);
		}
	}

	@Override
	public String toString() {
		return String.format("running NOT %s -> %s",a,o);
	}
}
