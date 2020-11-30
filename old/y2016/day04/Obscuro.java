package y2016.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Obscuro {
	
	public static final String regex = "(?<name>([a-z]+\\-)+)(?<id>\\d+)\\[(?<check>[a-z]+)\\]";
	public static final Pattern room = Pattern.compile(regex);
	static final File input = new File("C:/Users/jrdillingham.MABANKISD/Programing/workspace/adventofcode/src/y2016/day04/input.txt");
	
//	static final String input = "qzmt-zixmtkozy-ivhz-343[zimth]";
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(input);
		List<Room> rooms = new ArrayList<>();
		
		while (sc.hasNextLine()) {
			Matcher m = room.matcher(sc.nextLine());
			m.find();
			
			Room r = new Room(m.group("name"),Integer.parseInt(m.group("id")),m.group("check"));
			if (r.valid) rooms.add(r);
			
		}
		
		for (Room room : rooms) {
			System.out.println(
					String.format("%d: %s", room.id, decrypt(room.name, room.id)));
		}
		
		sc.close();
	}

	private static String decrypt(String name, int id) {
		int shift = id%26;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < name.length(); i++) {
			if(name.charAt(i)=='-'){
				sb.append(" ");
				continue;
			}
			
			char c = name.charAt(i);
			c=(char)((((c-97)+shift)%26)+97);
			sb.append(c);
		}
		
		return sb.toString();
		
	}

}
