package sudoku.main;

import sudoku.beans.Cell;
import sudoku.util.sudoku9x9Impl;

public class Client {

	public static void main(String args[]){
		sudoku9x9Impl impl=new sudoku9x9Impl();
		//impl.PrintBoard();
		//impl.inputBoard();
		impl.Init();

		try{
		if(impl.solve(new Cell(0,0))){
			System.out.println("UnSolvable...!");
			impl.PrintBoard();
		}
	}
		catch(ArrayIndexOutOfBoundsException e){
			
		}
		/*for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				impl.checkCell(new Cell(i,j));
			}
		}*/
	}
}
