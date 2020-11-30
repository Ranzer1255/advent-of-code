package y2017.day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class partOne {
	
	public static File inputFile = new File("C:/Users/jrdillingham.MABANKISD/Programing/workspace/adventofcode/src/day12/day12input");

	public static void main(String[] args) {
		
		Map<Integer,Program> tree = generateTree(inputFile);

		System.out.println("Size of group containing Program 0:" +findGroupSize(tree, 0));
		System.out.println("Total number of Groups: "+findGroups(tree));
		
		
	}

	private static int findGroups(Map<Integer, Program> tree) {
		
		List<Program> queue = new ArrayList<>(tree.values());
		int count = 0;
		while(!queue.isEmpty()){
			Program p = queue.remove(0);
			queue.removeAll(findGroup(tree, p.ID));
			count++;
		}
		
		return count;//TODO
	}

	/**
	 * scans the tree 
	 * @param tree 
	 * 
	 * @param id ID of tree root
	 */
	private static int findGroupSize(Map<Integer, Program> tree, int root) {		
		return findGroup(tree,root).size(); 
		
	}

	private static List<Program> findGroup(Map<Integer, Program> tree, int root) {
		List<Program> found = new ArrayList<>();
		Queue<Program> toCheck = new LinkedList<>();
		
		toCheck.add(tree.get(root));
		
		while(!toCheck.isEmpty()){
			Program node = toCheck.remove();
			if(!found.contains(node)){
				found.add(node);
				toCheck.addAll(node.getConnections());
			}
		}
		return found;
	}

	private static Map<Integer, Program> generateTree(File input) {
		HashMap<Integer,Program> rtn = new HashMap<>();
		
		try (Scanner read = new Scanner(input)){
			while (read.hasNextLine()){
				String parse = read.nextLine();
				
				Matcher m = Pattern.compile("\\d+").matcher(parse);
				
				int id=-1;
				boolean first = true;
				while (m.find()){
					if (first){
						id = Integer.parseInt(m.group());
						if(rtn.get(id)==null){
							rtn.put(id, new Program(id));
						}
						first=false;
					} else {
						assert(id!=-1);
						int con = Integer.parseInt(m.group());
						if (rtn.containsKey(con)){
							rtn.get(id).addConnection(rtn.get(con));							
						} else {
							Program p = new Program(con);
							rtn.put(con, p);
							rtn.get(id).addConnection(rtn.get(con));
						}
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rtn;
	}
	
	
}
