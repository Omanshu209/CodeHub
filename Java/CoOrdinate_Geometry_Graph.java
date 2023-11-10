/*
Example : 

x = 5
y = -2
x intercept = 4
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
*/

import java.util.Scanner;

public class CoOrdinate_Geometry
{
	static void showLine(double x, double y, double x_intercept)
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
			if(!(y_intercept % 1 == 0 || slope % 1 == 0))
			{
				isDecimal = true;
				System.out.println("[NOTE : The line below isn't straight since 1 or more of the values above is not an integer]");
			}
			
			for(int i = 10 ; i >= -10 ; i--)
			{
				// Straight Line Equation : y = mx + c
				double new_x = (i - y_intercept) / slope;
							
				for(double j = -10 ; j <= 10 ; j += 0.5)
				{
					if(j == new_x || (j == (int)new_x && isDecimal))
						System.out.print('*');
					
					else
					{
						if(i == 0 || j == 0)
						{
							char printVal = (i == 0) ? '-' : '|';
							System.out.print(printVal);
						}
						
						else
							System.out.print(' ');
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
		
		showLine(x, y, x_intercept);
	}
}
