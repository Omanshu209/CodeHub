/*
ROWS : 7
                     *
                    ***
                  *******
               *************
           *********************
      *******************************
*******************************************

|------------------------------------------------|
|------------------------------------------------|

ROWS : 5
          *
         ***
       *******
    *************
*********************
*/

import java.util.Scanner;

public class PATTERN
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ROWS : ");
		int rows = sc.nextInt();
		
		int startSpace = 0, stars = 1;
		
		for(int endSpace = rows - 1 ; endSpace >= 1 ; endSpace--)
			startSpace += endSpace;
		
		for(int i = 0 ; i < rows ; i++)
		{
			startSpace -= i;
			
			for(int k = startSpace ; k >= 1 ; k--)
				System.out.print(" ");
			
			stars += i * 2;
			
			for(int l = stars ; l >= 1 ; l--)
				System.out.print("*");
			
			System.out.println();
		}
	}
}
