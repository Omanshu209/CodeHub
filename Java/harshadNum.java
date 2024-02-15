// A no. is said to be a Harshad no. when it divided by the sum of its digits produces another Harshad no.

import java.util.Scanner;

public class harshadNum
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Number = ");
		double n = sc.nextInt(), prevNum = 0;
		
		boolean isHarshad = true;
		int sum;
		
		while(isHarshad && n >10 && n != prevNum)
		{
			prevNum = n;
			sum = 0;
			
			while(n > 0)
			{
				sum += n % 10;
				n /= 10;
			}
			
			n = prevNum / sum;
			
			if(n % 1 != 0)
				isHarshad = false;
		}
		
		if(isHarshad)
			System.out.println("It is a Harshad number");
		else
			System.out.println("It is not a Harshad number");
	}
}
