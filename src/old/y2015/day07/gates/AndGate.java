package y2015.day07.gates;

import y2015.day07.Wire;

public class AndGate extends Gate {

	Wire a;
	Wire b;

	public AndGate(Wire a, Wire b, Wire o){
		super(o);
		this.a = a;
		this.a.attachGate(this);
		this.b = b;
		this.b.attachGate(this);
	}

	@Override
	public void update() {
		if((a.getValue()==0 || b.getValue() == 0)&&o.getValue()!=0){ //output 0 until both read more than
			o.setValue(0);
		} else if (a.getValue()==0||b.getValue()==0) {//do nothing

		} else {
			int output = a.getValue() & b.getValue();
			o.setValue(output);
			System.out.println(this);
		}
	}

	@Override
	public String toString() {
		return String.format("running %s AND %s -> %s", a,b,o);
	}
}
