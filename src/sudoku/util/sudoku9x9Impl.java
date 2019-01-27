package sudoku.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import sudoku.beans.Cell;

public class sudoku9x9Impl implements Sudoku9x9Interface {

	public static int board[][]={
		{0, 2, 0, 4, 0, 0, 7, 0, 0},
        {7, 0, 0, 0, 0, 6, 0, 0, 8},
        {0, 8, 3, 0, 0, 0, 0, 0, 1},
        {0, 0, 2, 6, 0, 0, 0, 0, 0},
        {0, 5, 0, 0, 0, 0, 0, 7, 0},
        {0, 0, 0, 0, 0, 3, 9, 0, 0},
        {9, 0, 0, 0, 0, 0, 8, 3, 0},
        {3, 0, 0, 5, 0, 0, 0, 0, 7},
        {0, 0, 1, 0, 0, 4, 0, 6, 0},};
	
	Map<Integer,List<Cell>> map=new HashMap<Integer,List<Cell>>();

	@Override
	public void PrintBoard() {
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	@Override
	public void Init() {
	
		for(int i=1;i<=9;i++)
		{
			map.put(i, new ArrayList<Cell>());
		}
		
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				map.get(1).add(new Cell(i,j));
			}
			
			for(int j=3;j<6;j++)
			{
				map.get(2).add(new Cell(i,j));
			}
			
			for(int j=6;j<9;j++)
			{
				map.get(3).add(new Cell(i,j));
			}
		}
		
		for(int i=3;i<6;i++)
		{
			for(int j=0;j<3;j++)
			{
				map.get(4).add(new Cell(i,j));
			}
			
			for(int j=3;j<6;j++)
			{
				map.get(5).add(new Cell(i,j));
			}
			
			for(int j=6;j<9;j++)
			{
				map.get(6).add(new Cell(i,j));
			}
		}
		
		for(int i=6;i<9;i++)
		{
			for(int j=0;j<3;j++)
			{
				map.get(7).add(new Cell(i,j));
			}
			
			for(int j=3;j<6;j++)
			{
				map.get(8).add(new Cell(i,j));
			}
			
			for(int j=6;j<9;j++)
			{
				map.get(9).add(new Cell(i,j));
			}
		}
		
	//System.out.println(map);
	}

	@Override
	public void inputBoard() {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
			{
				board[i][j]=sc.nextInt();
			}
	}

	@Override
	public boolean uniqueInGroup(Cell cell) {
		int grpno=-1;
		for(int i=1;i<=9;i++)
		{
			List<Cell> list=map.get(i);
			if(list.contains(cell))
			{
				grpno=i;
			}
		}
		
		List<Cell> list=map.get(grpno);
		for(int i=0;i<9;i++)
		{
			if(list.get(i).equals(cell))
			{
				continue;
			}
			
			if(board[list.get(i).x][list.get(i).y]== board[cell.x][cell.y] && board[cell.x][cell.y]!=0)
			{
				return false;
			}
		}
		
		
		return true;
	}

	@Override
	public boolean isAlreadyPlaced(int num, int row, int col) {
		
		for(int i=0;i<9;i++)
		{
			if(board[row][i]==num || board[i][col]==num)
			{
				
				return true;//duplicate exits
			}
		}
		
		Cell cell=new Cell(row,col);
		return false;
	}

	@Override
	public boolean place(Cell cell, int num) {
		if(!isAlreadyPlaced(num,cell.x,cell.y))
		{
			board[cell.x][cell.y]=num;
			return true;
		}
		return false;
	}

	@Override
	public Cell getNetCell(Cell prevCell) {
			Cell cell=new Cell(prevCell.x,prevCell.y);
			if(prevCell.y==8)
			{
				cell.y=0;
				cell.x++;
			}
			else
			{
				cell.y++;
			}
		return cell;
	}

	@Override
	public boolean solve(Cell cell) {
		
		if(board[cell.x][cell.y]!=0)
		{
			if(cell.x==8 && cell.y==8)
			{
				PrintBoard();
				//System.exit(0);
			}
		
		Cell cell1=getNetCell(cell);
		return solve(cell1);
		}
		
		for(int i=1;i<=9;i++)
		{
			Boolean placed=place(cell,i);
			if(placed)
			{
				if(!uniqueInGroup(cell))
				{
					continue;
				}
				
				if(cell.x==8 && cell.y==8)
				{
					PrintBoard();
					//System.exit(0);
				}
				
				Cell cell2=getNetCell(cell);
				solve(cell2);
				
				
			}
		}
		
		board[cell.x][cell.y]=0;
		
		return true;
	}

	@Override
	public void checkCell(Cell c) {
		
		int value=board[c.x][c.y];
		board[c.x][c.y]=0;
		int r=c.x;
		int y=c.y;
		for(int i=0;i<9;i++)
		{
			if(board[i][y]==value)
			{
				System.out.println("failed");
			}
		}
		for(int i=0;i<9;i++)
		{
			if(board[r][i]==value)
			{
				System.out.println("failed");
			}
		}
		board[c.x][c.y]=value;
		
	}
	

}
