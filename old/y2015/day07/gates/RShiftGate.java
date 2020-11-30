package y2015.day07.gates;

import y2015.day07.Wire;

public class RShiftGate extends Gate{
	Wire a;
	int distance;

	public RShiftGate(Wire a, int distance, Wire o){
		super(o);
		this.a = a;
		this.a.attachGate(this);
		this.distance = distance;

		update();
	}

	@Override
	public void update() {
		o.setValue(a.getValue()>>distance);
		System.out.println(this);
	}

	@Override
	public String toString() {
		return String.format("running %s RSHIFT %d -> %s",a,distance,o);
	}
}