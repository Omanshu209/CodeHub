/*
*******
 *   *
  * *
   *
  * *
 *   *
*******
*/

public class Hour_Glass_PATTERN_2
{
	public static void main(String[] args)
	{
		for(int i = 1 ; i <= 7 ; i++)
		{
			for(int j = 1 ; j <= 7 ; j++)
			{
				if((i % 7 <= 1) || (i == j) || (i + j == 8))
					System.out.print("*");
				
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
