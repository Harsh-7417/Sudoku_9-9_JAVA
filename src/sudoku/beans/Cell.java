package sudoku.beans;

import sudoku.util.sudoku9x9Impl;

public class Cell {

	public int x,y,value;
	
	
	
	public Cell(int x, int y) {
		
		this.x = x;
		this.y = y;
		this.value =sudoku9x9Impl.board[x][y];
	}

	@Override
	public int hashCode() {
		return Integer.parseInt(x+""+y);
	}

	@Override
	public boolean equals(Object obj) {
		
			Cell cell=(Cell) obj;
			return this.x==cell.x && this.y==cell.y;
		
	}

	@Override
	public String toString() {
		return " [" + x + ", " + y + "]";
	}

	
	
	
}
