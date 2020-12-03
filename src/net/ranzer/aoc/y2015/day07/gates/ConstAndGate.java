package net.ranzer.aoc.y2015.day07.gates;

import net.ranzer.aoc.y2015.day07.Wire;

public class ConstAndGate extends Gate {

//	Wire a;
	Wire b;

//	Wire lastCaller = null;
//
	public ConstAndGate(Wire b, Wire o){
		super(o);
//		this.a = a;
//		this.a.attachGate(this);
		this.b = b;
		this.b.attachGate(this);
	}
//
	@Override
	public void update() {
//
//			int output = 1 & b.getValue();
//			o.setValue(output);
//			System.out.println(this);
////			lastCaller=null;
	}
//
//	@Override
//	public String toString() {
//		return String.format("running %d AND %s -> %s", 1,b,o);
//	}
}
