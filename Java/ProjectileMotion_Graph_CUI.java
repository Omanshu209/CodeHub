/*
==================================================================

Example 1 : 

-------------------------
Initial Velocity u (m/s) : 25
Angle Of Projection θ (degrees) : 45
Acceleration Due To Gravity g (m/s²) : 10
-------------------------
Maximum Height : 15.624999999999995 m
Horizontal Range : 62.5 m
Time Of Flight : 3.535533905932737 s
-------------------------
                             ******
                       ******      *****
                    ***                 ***
                  **                       ***
                **                            **
              **                                **
            **                                    *
           *                                       **
         **                                          *
        *                                             **
       *                                                *
     **                                                  *
    *                                                     *
   *                                                       *
  *                                                         *
 *                                                           *
*                                                             *

==================================================================

Example 2 : 

-------------------------
Initial Velocity u (m/s) : 10
Angle Of Projection θ (degrees) : 70
Acceleration Due To Gravity g (m/s²) : 1.6
-------------------------
Maximum Height : 27.59444442373403 m
Horizontal Range : 40.17422560540871 m
Time Of Flight : 11.746157759823854 s
-------------------------
                   ***
                 **   ***
               **        *
              *           *
             *             *
            *               *
           *                 *
          *                   *

         *                     *
        *                       *

       *                         *

      *                           *

     *                             *

    *                               *

   *                                 *

                                      *
  *

 *                                     *


*                                       *

==================================================================

Example 3 : 

-------------------------
Initial Velocity u (m/s) : 5
Angle Of Projection θ (degrees) : 80
Acceleration Due To Gravity g (m/s²) : 0.2
-------------------------
Maximum Height : 60.61539439955962 m
Horizontal Range : 42.7525179157086 m
Time Of Flight : 49.240387650610394 s
-------------------------
                     **
                   **  **
                  *      *
                 *        *
                *
                           *
               *            *

              *              *

             *                *

            *
                               *

           *                    *


          *                      *


         *
                                  *

        *
                                   *


       *
                                    *


      *
                                     *


     *
                                      *


    *

                                       *


   *
                                        *



  *
                                         *



 *

                                          *



*

==================================================================
*/

import java.util.Scanner;

public class projectilePattern
{
	private double u, angle, g, a, b, radians;
	private int y_coordinate, horizontal_range, max_height;
	private static final String RED = "\u001B[31m", GREEN = "\u001B[32m", RESET = "\u001B[0m";
	
	projectilePattern(double u_vel, double angle_deg, double acc_g)
	{
		u = u_vel;
		angle = angle_deg;
		g = acc_g;
		radians = Math.toRadians(angle_deg);
		max_height = (int)Math.round(get_maximum_height(u, g));
		horizontal_range = (int)Math.round(get_horizontal_range(u, g));
	}
	
	private double get_horizontal_range(double u_vel, double acc_g)
	{
		// Horizontal Range R = (u²•sin(2θ)) / g = (2u²•sinθ•cosθ) / g
		return ((u_vel * u_vel * 2 * Math.sin(radians) * Math.cos(radians)) / acc_g);
	}
	
	private double get_maximum_height(double u_vel, double acc_g)
	{
		// Maximum Height H = (u•sinθ)² / 2g
		return (Math.pow(u_vel * Math.sin(radians), 2) / (2 * g));
	}
	
	private double get_time_of_flight(double u_vel, double acc_g)
	{
		// Time Of Flight T = (2u•sinθ) / g
		return ((2 * u_vel * Math.sin(radians)) / acc_g);
	}
	
	private int get_y_coordinate(int x)
	{
		// Equation Of Trajectory : y = (x•tanθ) - (gx²) / (2u²•cos²θ)
		int y = (int)Math.round((x * Math.tan(radians)) - (g * x * x) / (2 * Math.pow(u * Math.cos(radians), 2)));
		
		return y;
	}
	
	public void print_projectile()
	{
		System.out.println(
		"-------------------------" + "\n" + 
		RED + 
		"Maximum Height : " + get_maximum_height(u, g) + " m" + "\n" + 
		"Horizontal Range : " + get_horizontal_range(u, g) + " m" + "\n" + 
		"Time Of Flight : " + get_time_of_flight(u, g) + " s" + "\n" + 
		RESET + 
		"-------------------------"
		);
		
		System.out.print(GREEN);
		
		for(int i = max_height ; i >= 0 ; i--)
		{
			for(int j = 0 ; j <= horizontal_range ; j++)
			{
				y_coordinate = get_y_coordinate(j);
				
				if(i == y_coordinate)
					System.out.print('*');
				
				else
					System.out.print(' ');
			}
			System.out.println();
		}
		
		System.out.print(RESET);
	}
}

class main_class
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-------------------------");
		
		System.out.print("Initial Velocity u (m/s) : ");
		double u = sc.nextDouble();
		
		System.out.print("Angle Of Projection θ (degrees) : ");
		double angle = sc.nextDouble();
		
		System.out.print("Acceleration Due To Gravity g (m/s²) : ");
		double g = sc.nextDouble();
		
		projectilePattern projectile_pattern = new projectilePattern(u, angle, g);
		projectile_pattern.print_projectile();
		
		System.out.println("-------------------------");
	}
}
