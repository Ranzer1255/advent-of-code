package net.ranzer.aoc.y2021.day04;

import java.util.ArrayList;

public class BingoBoard {

	ArrayList<Cell> grid = new ArrayList<>(25);

	public BingoBoard(){

	}

	public boolean isFinished(){
		for (int i = 0; i < 5; i++) {
			if(checkUnmarked(getRow(i))) return false;
			if(checkUnmarked(getCol(i))) return false;
		}
		return true;
	}

	public int Score(){
		int unmarked=0;
		int marked=0;

		for (Cell c: grid){
			if(c.isMarked()) marked+=c.value;
			else             unmarked+=c.value;
		}

		return marked*unmarked;
	}

	private boolean checkUnmarked(ArrayList<Cell> set) {
		for (Cell c:set){
			if(!c.isMarked()){
				return true;
			}
		}
		return false;
	}

	private ArrayList<Cell> getRow(int index){
		return (ArrayList<Cell>)grid.subList(index*5,index*5+5);
	}

	private ArrayList<Cell> getCol(int index){
		ArrayList<Cell> rtn = new ArrayList<>();

		rtn.add(grid.get(index));
		rtn.add(grid.get(index+5));
		rtn.add(grid.get(index+10));
		rtn.add(grid.get(index+15));
		rtn.add(grid.get(index+20));

		return rtn;
	}

	public static class Cell{

		public final int value;
		private boolean marked = false;

		public Cell(int value){
			this.value=value;
		}

		public void mark(){
			marked=true;
		}

		public boolean isMarked(){
			return marked;
		}
	}
}
