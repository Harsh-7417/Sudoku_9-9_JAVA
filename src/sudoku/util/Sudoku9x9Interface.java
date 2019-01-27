package sudoku.util;

import sudoku.beans.Cell;

public interface Sudoku9x9Interface {

	void PrintBoard();
	void Init();
	void inputBoard();
	boolean uniqueInGroup(Cell cell);
	boolean isAlreadyPlaced(int num,int row,int col);
	//boolean checkLoss(Cell cell);
	boolean place(Cell cell,int num);
	Cell getNetCell(Cell prevCell);
	boolean solve(Cell cell);
	void checkCell(Cell c);
	
	
}
