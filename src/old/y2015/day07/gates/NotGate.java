package y2015.day07.gates;

import y2015.day07.Wire;

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
		o.setValue(~a.getValue());
		System.out.println(this);
	}

	@Override
	public String toString() {
		return String.format("running NOT %s -> %s",a,o);
	}
}
