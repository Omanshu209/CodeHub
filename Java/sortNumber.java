// Sort a number in ascending order of its digits
// using only the Integer data type

import java.util.Scanner;

public class sortNumber
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Number : ");
		int num = sc.nextInt();
		
		int newNum = num % 10, digit, prevNum, mul, tempNum, tempMul;
		num /= 10;
		
		while(num > 0)
		{
			digit = num % 10;
			mul = 1;
			prevNum = newNum;
			
			while(prevNum > 0)
			{
				if(prevNum < 10 && prevNum > digit)
				{
					//double digits = Math.ceil(Math.log10(Math.abs(newNum)));
					newNum += digit * mul * 10;
					break;
				}
				
				else if((prevNum % 10) <= digit)
				{
					tempMul = 1;
					tempNum = newNum % mul;
					newNum /= mul;
					
					while(newNum > 0)
					{
						tempNum += (newNum % 10) * tempMul * mul * 10;
						tempMul *= 10;
						newNum /= 10;
					}
					
					newNum = tempNum;
					newNum += digit * mul;
					break;
				}
				
				mul *= 10;
				prevNum /= 10;
			}
			
			num /= 10;
		}
		
		System.out.println("Sorted Number : " + newNum);
	}
}
