package y2016.day04;

import java.util.HashMap;
import java.util.Map;

public class Room {
	
	public String name;
	public int id;
	public String checksum;
	public final boolean valid;
	
	public Room(String name, int id, String checksum){
		System.out.println(checksum);
		this.name=name;
		this.id=id;
		this.checksum=checksum;
		valid = checkValidity();
	}

	private boolean checkValidity() {
		
		Map<Character, Integer> letters = alphaMap();
		
		String letterString = name.replaceAll("-", "");
		
		for (int i = 0; i < letterString.length(); i++) {
			char letter = letterString.charAt(i);
			letters.put(letter, letters.get(letter).intValue()+1);			
		}
		StringBuilder sb = new StringBuilder(5);
		letters.entrySet().stream().sorted((o1,o2)->{
			if(o1.getValue().equals(o2.getValue()))
				return o1.getKey().compareTo(o2.getKey());
			return o1.getValue().compareTo(o2.getValue())*-1;
		}).limit(5).forEach(o->sb.append(o.getKey().charValue()));

		return checksum.equals(sb.toString());
	}

	private Map<Character, Integer> alphaMap() {
		Map<Character, Integer> rtn = new HashMap<>();
		
		for(int i=97;i<123;i++){
			rtn.put((char)(i), 0);
		}
		
		return rtn;
	}

}
