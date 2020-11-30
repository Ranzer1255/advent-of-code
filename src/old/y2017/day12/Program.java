package y2017.day12;

import java.util.ArrayList;
import java.util.List;

public class Program {
	public final int ID;
	private List<Program> connections;

	public Program(int id, List<Program> connections) {
		
		ID=id;
		this.connections=connections;
	}
	
	public Program(int id){
		ID=id;
		connections = new ArrayList<>();
	}
	
	public void addConnection(Program p){
		connections.add(p);
	}
	
	public List<Program> getConnections(){
		return connections;
	}
	
	@Override
	public String toString() {
		return String.format("%d <-> %s", ID, conToString());
	}

	private String conToString() {
		StringBuilder sb = new StringBuilder();
		
		for (Program program : connections) {
			sb.append(String.format(", %d", program.ID));
		}
		
		return sb.substring(2);
	}
}