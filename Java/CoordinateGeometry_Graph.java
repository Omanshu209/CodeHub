/*
Example 1 : 

Input :

x = 5
y = -2
x intercept = 4
Show Co-ordinates (y/n) : n
Maximum Co-ordinate : 10

Output :

====================
x : 5.0
y : -2.0
x intercept : 4.0
y intercept : 8.0
Slope : -2.0
Maximum Unit(Maximum Co-ordinate) : 10
Co-ordinate Visibility : false
====================
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

.......................................

Example 2 :

Input :

x = 3
y = -3
x intercept = 6
Show Co-ordinates (y/n) : y
Maximum Co-ordinate : 10

Output :

====================
x : 3.0
y : -3.0
x intercept : 6.0
y intercept : -6.0
Slope : 1.0
Maximum Unit(Maximum Co-ordinate) : 10
Co-ordinate Visibility : true
====================
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

.......................................

Example 3 :

Input :

x = -3
y = 3
x intercept = 6
Show Co-ordinates (y/n) : y
Maximum Co-ordinate : 12

Output :

====================
x : -3.0
y : 3.0
x intercept : 6.0
y intercept : 2.0
Slope : -0.3333333333333333
Maximum Unit(Maximum Co-ordinate) : 12
Co-ordinate Visibility : true
====================
[NOTE : The line below isn't straight since 1 or more of the values above is not an integer]
[NOTE : "Show Co-Ordinate" feature is not available for these inputs as 1 or more of the values above is not an integer]
                        |
                        |
                        |
                        |
                        |
                        |
*                       |
      *                 |
            *           |
                  *     |
                        *
                        |     *
------------------------------------*------------
                        |                 *
                        |                       *
                        |
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

class CoordinateGeometry
{
	private static double x, y, x_intercept, y_intercept, slope, new_x;
	private static boolean showCoordinates, isDecimal, graphVisibility;
	private static int maxUnit;
	private static final String RED = "\u001B[31m", GREEN = "\u001B[32m", BLUE = "\u001B[34m", PURPLE = "\u001B[35m", RESET = "\u001B[0m";
	private static String graph, data;
	
	CoordinateGeometry(boolean GraphVisibility)
	{
		graphVisibility = GraphVisibility;
	}
	
	public static double get_y_intercept(double X, double Y, double X_intercept)
	{
		try
		{
			// Intercept Form : (x / a) + (y / b) = 1
			return (X_intercept * Y) / (X_intercept - X);
		}
		
		catch(ArithmeticException e)
		{
			System.out.println("Error : Division by Zero");
		}
		
		return 0;
	}
	
	public static double get_slope(double X, double Y, double Y_intercept)
	{
		try
		{
			// Straight Line Equation : y = mx + c
			return (Y - Y_intercept) / X;
		}
		
		catch(ArithmeticException e)
		{
			System.out.println("Error : Division by Zero");
		}
		
		return 0;
	}
	
	public static double get_x(int Y, double Y_intercept, double Slope)
	{
		try
		{
			// Straight Line Equation : y = mx + c
			return (Y - Y_intercept) / Slope;
		}
		
		catch(ArithmeticException e)
		{
			System.out.println("Error : Division by Zero");
		}
		
		return 0;
	}
	
	public static void setData(double X, double Y, double X_intercept, boolean ShowCoordinates, int MaxUnit)
	{
		x = X;
		y = Y;
		x_intercept = X_intercept;
		showCoordinates = ShowCoordinates;
		maxUnit = MaxUnit;
		y_intercept = get_y_intercept(X, Y, X_intercept);
		slope = get_slope(X, Y, y_intercept);
		
		data = 
		"x : " + x + "\n" +
		"y : " + y + "\n" +
		"x intercept : " + x_intercept + "\n" +
		"y intercept : " + y_intercept + "\n" +
		"Slope : " + slope + "\n" +
		"Maximum Unit(Maximum Co-ordinate) : " + maxUnit + "\n" +
		"Co-ordinate Visibility : " + ShowCoordinates + "\n";
	}
	
	public static void constructGraph()
	{
		graph = "";
		
		isDecimal = false;
		if(!(y_intercept % 1 == 0 && slope % 1 == 0))
		{
			isDecimal = true;
				
			graph +=
				RED + 
				"[NOTE : The line below isn't straight since 1 or more of the values above is not an integer]" + 
				RESET +
				"\n";
				
			if(showCoordinates)
			{
				showCoordinates = false;
					
				graph +=
					RED + 
					"[NOTE : \"Show Co-Ordinate\" feature is not available for these inputs as 1 or more of the values above is not an integer]" + 
					RESET +
					"\n";
			}
		}
			
		for(int i = maxUnit ; i >= -maxUnit ; i--)
		{
			new_x = get_x(i, y_intercept, slope);
							
			for(double j = -maxUnit ; j <= maxUnit ; j += 0.5)
			{
				if(j == new_x || (j == (int)new_x && isDecimal))
				{
					if(showCoordinates)
						graph +=
							GREEN + 
							"*  " + 
							RESET + 
							"(" + j + "," + i + ")";
						
					else
						graph +=
							GREEN + 
							"*" + 
							RESET;
				}
				
				else
				{
					if(i == 0 || j == 0)
					{
						if(showCoordinates && (new_x + 5 > j) && (new_x < j))
							continue;
							
						graph +=
							(i == 0)
							? BLUE + "-" + RESET 
							: BLUE + "|" + RESET;
					}
					
					else
					{
						if(showCoordinates && (new_x + 5 > j) && (new_x < j))
							continue;
						graph += " ";
					}
				}
			}
			graph += "\n";
		}
	}
	
	public static void showData()
	{
		if(graphVisibility)
			System.out.print(
			PURPLE + 
			"====================\n" + 
			data + 
			"====================\n" + 
			RESET
			);
	}
	
	public static void showGraph()
	{
		if(graphVisibility)
			System.out.println(graph);
	}
}

public class MAIN
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("x = ");
		double x = sc.nextDouble();
		
		System.out.print("y = ");
		double y = sc.nextDouble();
		
		System.out.print("x intercept = ");
		double x_intercept = sc.nextDouble();
		
		System.out.print("Show Co-ordinates (y/n) : ");
		boolean showCoordinates = 
		(sc.next().charAt(0) == 'y') 
		? true 
		: false;
		
		System.out.print("Maximum Co-ordinate : ");
		int maxUnit = sc.nextInt();
		
		CoordinateGeometry GRAPH = new CoordinateGeometry(true);
		GRAPH.setData(x, y, x_intercept, showCoordinates, maxUnit);
		GRAPH.constructGraph();
		GRAPH.showData();
		GRAPH.showGraph();
	}
}
//Developed by Omanshu
