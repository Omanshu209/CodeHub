//import java.util.Scanner;

public class NumberSystemConverter
{
	public static long binaryToDecimal(long binary)
	{
		long decimal = 0;
		
		for(int exp = 0 ; binary > 0 ; exp++)
		{
			decimal += binary % 2 * Math.pow(2, exp);
			binary /= 10;
		}
		
		return decimal;
	}
	
	public static long decimalToBinary(long decimal)
	{
		long binary = 0;
		
		for(int exp = 0 ; decimal > 0 ; exp++)
		{
			binary += decimal % 2 * Math.pow(10, exp);
			decimal /= 2;
		}
		
		return binary;
	}
	
	public static void main(String[] args)
	{
		//Scanner sc = new Scanner(System.in);
		
		/* BINARY TO DECIMAL
		
		System.out.print("Enter the binary number : ");
		long binary = sc.nextLong();
		
		System.out.println("Decimal number : " + decimalToBinary(binary));
		
		*/
		
		/* DECIMAL TO BINARY
		
		System.out.print("Enter the binary number : ");
		long binary = sc.nextLong();
		
		System.out.println("Decimal number : " + binaryToDecimal(binary));
		
		*/
	}
}
