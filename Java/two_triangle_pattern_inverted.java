/*
PATTERN:

*********
**** ****
***   ***
**     **
*       *
*/

public class two_triangle_pattern_inverted
{
	public static void main(String[] args)
	{
		for(int i = 5 ; i >= 1 ; i--)
		{
			for(int j = 1 ; j < 10 ; j++)
			{
				if(j > i && j < (10 - i))
					System.out.print(' ');
				else
					System.out.print('*');
			}
			
			System.out.println();
		}
	}
}
