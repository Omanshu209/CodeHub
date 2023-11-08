/*
5 , 
10 , 4 , 
15 , 8 , 3 , 
20 , 12 , 6 , 2 , 
25 , 16 , 9 , 4 , 1 , 
*/

public class NumMul_Triangle
{
	public static void main(String[] args)
	{
		for(int i = 1 ; i <= 5 ; i++)
		{
			int f = i;
			
			for(int j = 1 ; j <= i ; j++)
			{
				System.out.print((f * (6 - j)) + " , ");
				f--;
			}
			
			System.out.println();
		}
	}
}
