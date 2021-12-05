package net.ranzer.aoc.y2021.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BingoBoard {

	ArrayList<Cell> grid = new ArrayList<>(25);

	public BingoBoard(ArrayList<Integer> values){
		for (int v : values) {
			grid.add(new Cell(v));
		}
	}

	public boolean mark(int value){
		for (Cell c : grid) {
			if (c.value == value) {
				c.mark();
				return isFinished();
			}
		}
		return false;
	}

	public boolean isFinished(){
		for (int i = 0; i < 5; i++) {
			if(checkMarked(getRow(i))) return true;
			if(checkMarked(getCol(i))) return true;
		}
		return false;
	}

	public int score(int value){
		int unmarked=0;

		for (Cell c: grid){
			if(!c.isMarked()) unmarked+=c.value;
		}

		return value*unmarked;
	}

	private boolean checkMarked(List<Cell> set) {
		for (Cell c:set){
			if(!c.isMarked()){
				return false;
			}
		}
		return true;
	}

	private List<Cell> getRow(int index){
		return grid.subList(index*5,index*5+5);
	}

	private List<Cell> getCol(int index){
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

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Cell cell = (Cell) o;
			return value == cell.value;
		}

		@Override
		public int hashCode() {
			return Objects.hash(value);
		}
	}

	@Override
	public String toString() {
		StringBuilder rtn = new StringBuilder();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Cell c = grid.get(j+i*5);
				rtn.append(c.value).append(c.marked?"*":" ");
				if (c.value<10) rtn.append(" ");
				rtn.append(" ");
			}
			rtn.append("\n");
		}

		return rtn.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BingoBoard that = (BingoBoard) o;
		return Objects.equals(grid, that.grid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(grid);
	}
}
