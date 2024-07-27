/*
PROGRAMMERS MEET 2K24

Q3) "NUMBER SWAP PUZZLE"

In this game the player is presented with 3x3 grid of numbers where one cell is empty and the goal is to arrange the numbers in a specific order by swapping adjacent numbers.

Here's how the game works:
	- The game starts with a randomly shuffled 3x3 grid of numbers with one empty cell.
	- The player can now move a number into the empty cell if they are adjacent(up, down, left, or right).
	- The goal is to arrange the numbers in ascending order from 1 to 8 with the empty cell at the end.
*/

import java.util.Scanner;

public class Main
{
	public static void printGrid(int[][] arr)
	{
		for(int i = 0 ; i < 3 ; i++)
		{
			for(int j = 0 ; j < 3 ; j++)
			{
				if(arr[i][j] == 0)
				{
					System.out.print("*  ");
					continue;
				}
				
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public static boolean isArranged(int[][] arr)
	{
		int k = 1;
		
		for(int i = 0 ; i < 3 ; i++)
		{
			for(int j = 0 ; j < 3 ; j++)
			{
				if(i == 2 && j == 2)
					continue;
				
				else if(arr[i][j] != k)
					return false;
				
				k++;
			}
		}
		
		return true;
	}
	
	public static int[] getEmptyPos(int[][] arr)
	{
		int[] pos = new int[2];
		
		for(int i = 0 ; i < 3 ; i++)
			for(int j = 0 ; j < 3 ; j++)
				if(arr[i][j] == 0)
				{
					pos[0] = i;
					pos[1] = j;
				}
		
		return pos;
	}
	
	public static int[][] moveDown(int[][] grid)
	{
		int[] pos = getEmptyPos(grid);
		
		if(pos[0] + 1 >= 3)
			return grid;
		
		int temp = grid[pos[0]][pos[1]];
		grid[pos[0]][pos[1]] = grid[pos[0] + 1][pos[1]];
		grid[pos[0] + 1][pos[1]] = temp;
		
		return grid;
	}
	
	public static int[][] moveUp(int[][] grid)
	{
		int[] pos = getEmptyPos(grid);
		
		if(pos[0] - 1 < 0)
			return grid;
		
		int temp = grid[pos[0]][pos[1]];
		grid[pos[0]][pos[1]] = grid[pos[0] - 1][pos[1]];
		grid[pos[0] - 1][pos[1]] = temp;
		
		return grid;
	}
	
	public static int[][] moveRight(int[][] grid)
	{
		int[] pos = getEmptyPos(grid);
		
		if(pos[1] + 1 >= 3)
			return grid;
		
		int temp = grid[pos[0]][pos[1]];
		grid[pos[0]][pos[1]] = grid[pos[0]][pos[1] + 1];
		grid[pos[0]][pos[1] + 1] = temp;
		
		return grid;
	}
	
	public static int[][] moveLeft(int[][] grid)
	{
		int[] pos = getEmptyPos(grid);
		
		if(pos[1] - 1 < 0)
			return grid;
		
		int temp = grid[pos[0]][pos[1]];
		grid[pos[0]][pos[1]] = grid[pos[0]][pos[1] - 1];
		grid[pos[0]][pos[1] - 1] = temp;
		
		return grid;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int[][] grid = new int[3][3];
		
		// Assigning random values...
		for(int i = 1 ; i < 9 ; i++)
		{
			int randomRow = (int) Math.floor(Math.random() * 10 / 3);
			int randomCol = (int) Math.floor(Math.random() * 10 / 3);
			
			while(randomRow == 3)
				randomRow = (int) Math.floor(Math.random() * 10 / 3);
			while(randomCol == 3)
				randomCol = (int) Math.floor(Math.random() * 10 / 3);
			
			if(grid[randomRow][randomCol] != 0)
			{
				i--;
				continue;
			}
			
			grid[randomRow][randomCol] = i;
		}
		
		int movesTaken = 0;
		
		while(!isArranged(grid))
		{
			
			printGrid(grid);
			
			System.out.print("\nMove (U/D/L/R) : ");
			char move = sc.next().charAt(0);
			
			switch(move)
			{
				case 'U':
					grid = moveUp(grid);
					break;
				
				case 'D':
					grid = moveDown(grid);
					break;
				
				case 'L':
					grid = moveLeft(grid);
					break;
				
				case 'R':
					grid = moveRight(grid);
					break;
			}
			
			movesTaken++;
			
			System.out.println("\n--------------------\n");
		}
		
		System.out.println(
			"YOU WON!" + "\n" +
			"MOVES TAKEN : " + movesTaken
		);
	}
}
