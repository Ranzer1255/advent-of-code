package y2015.day07.gates;

import y2015.day07.Wire;

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
		o.setValue(a.getValue());
		System.out.println(this);
	}

	@Override
	public String toString() {
		return String.format("Running %s -> %s",a,o);
	}
}
