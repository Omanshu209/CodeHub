/*
Example 1 : 

x = 5
y = -2
x intercept = 4
Show Co-ordinates (true / false) : false
y_intercept = 8.0
Slope = -2.0
                  * |
                   *|
                    *
                    |*
                    | *
                    |  *
                    |   *
                    |    *
                    |     *
                    |      *
----------------------------*------------
                    |        *
                    |         *
                    |          *
                    |           *
                    |            *
                    |             *
                    |              *
                    |               *
                    |                *
                    |                 *

=======================================

Example 2 :

x = 3
y = -3
x intercept = 6
Show Co-ordinates (true / false) : true
y_intercept = -6.0
Slope = 1.0
                    |
                    |
                    |
                    |
                    |
                    |
                    |                   *  (10.0,4)
                    |                 *  (9.0,3)
                    |               *  (8.0,2)
                    |             *  (7.0,1)
--------------------------------*  (6.0,0)
                    |         *  (5.0,-1)
                    |       *  (4.0,-2)
                    |     *  (3.0,-3)
                    |   *  (2.0,-4)
                    | *  (1.0,-5)
                    *  (0.0,-6)
                  *  (-1.0,-7)
                *  (-2.0,-8)
              *  (-3.0,-9)
            *  (-4.0,-10)

=======================================

Example 3 :

x = -3
y = 3
x intercept = 6
Show Co-ordinates (true / false) : true
y_intercept = 2.0
Slope = -0.3333333333333333
[NOTE : The line below isn't straight since 1 or more of the values above is not an integer]
[NOTE : "Show Co-Ordinate" feature is not available for these inputs as 1 or more of the values above is not an integer]
                    |
                    |
                    |
                    |
                    |
  *                 |
        *           |
              *     |
                    *
                    |     *
--------------------------------*--------
                    |                 *
                    |
                    |
                    |
                    |
                    |
                    |
                    |
                    |
                    |
*/

import java.util.Scanner;

public class CoOrdinate_Geometry
{
	static void showLine(double x, double y, double x_intercept, boolean showCoordinates)
	{
		try
		{
			// Intercept Form : (x / a) + (y / b) = 1
			double y_intercept = (x_intercept * y) / (x_intercept - x);
			
			// Straight Line Equation : y = mx + c
			double slope = (y - y_intercept) / x;
			
			System.out.println("y_intercept = " + y_intercept);
			System.out.println("Slope = " + slope);
			
			boolean isDecimal = false;
			if(!(y_intercept % 1 == 0 && slope % 1 == 0))
			{
				isDecimal = true;
				System.out.println("[NOTE : The line below isn't straight since 1 or more of the values above is not an integer]");
				
				if(showCoordinates)
				{
					showCoordinates = false;
					System.out.println("[NOTE : \"Show Co-Ordinate\" feature is not available for these inputs as 1 or more of the values above is not an integer]");
				}
			}
			
			for(int i = 10 ; i >= -10 ; i--)
			{
				// Straight Line Equation : y = mx + c
				double new_x = (i - y_intercept) / slope;
							
				for(double j = -10 ; j <= 10 ; j += 0.5)
				{
					if(j == new_x || (j == (int)new_x && isDecimal))
					{
						if(showCoordinates)
							System.out.print("*  " + "(" + j + "," + i + ")");
						
						else
							System.out.print('*');
					}
					
					else
					{
						if(i == 0 || j == 0)
						{
							if(showCoordinates && (new_x + 5 > j) && (new_x < j))
								continue;
							
							char printVal = (i == 0) ? '-' : '|';
							System.out.print(printVal);
						}
						
						else
						{
							if(showCoordinates && (new_x + 5 > j) && (new_x < j))
								continue;
							System.out.print(' ');
						}
					}
				}
				System.out.println();
			}
		}
		
		catch(ArithmeticException e)
		{
			System.out.println("Error : Division by Zero");
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("x = ");
		double x = sc.nextDouble();
		
		System.out.print("y = ");
		double y = sc.nextDouble();
		
		System.out.print("x intercept = ");
		double x_intercept = sc.nextDouble();
		
		System.out.print("Show Co-ordinates (true / false) : ");
		boolean showCoordinates = sc.nextBoolean();
		
		showLine(x, y, x_intercept, showCoordinates);
	}
}
//Developed by Omanshu
