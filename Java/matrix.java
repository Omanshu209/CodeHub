/*
W.A.P. to create a matrix of size a x b. Print it out!
Inputs to be taken : a, b, elements of the matrix
*/

import java.util.Scanner;

public class matrix
{
	private static Scanner sc = new Scanner(System.in);
	
	static int[][] createMatrix(int a, int b)
	{
		int[][] matrix = new int[a][b];
		for(int i = 0 ; i < a ; i++)
		{
			for(int j = 0 ; j < b ; j++)
			{
				System.out.print("matrix[" + (i + 1) + "," + (j + 1) + "] : ");
				matrix[i][j] = sc.nextInt();
			}
		}
		return matrix;
	}
	
	static void printMatrix(int[][] matrix)
	{
		System.out.println("\nmatrix[" + matrix.length + "," + matrix[0].length + "] ->\n");
		
		for(int i = 0 ; i < matrix.length ; i++)
		{
			System.out.print("\t");
			for(int j = 0 ; j < matrix[i].length ; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("Number of rows & columns : ");
		printMatrix(createMatrix(sc.nextInt(), sc.nextInt()));
	}
}
