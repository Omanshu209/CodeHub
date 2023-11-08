/*
*****
 * *
  *
 * *
*****
*/

public class Hour_Glass_PATTERN_1
{
	public static void main(String[] args)
	{
		for(int i = 2 ; i <= 10 ; i += 2)
		{
			for(int j = 1 ; j <= 5 ; j++)
			{
				if((i % 10 <= 2) || (i % 10 != 6 && j % 2 == 0) || (i % 10 == 6 && j == 3))
					System.out.print("*");
				
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
