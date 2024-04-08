import java.util.Scanner;

public class techNumber
{
	private static int getDigitCount(int num)
	{
		return ((int) Math.ceil(Math.log10(num)));
	}
	
	public static boolean isTechNumber(int num)
	{
		int digits = getDigitCount(num);
		if(digits % 2 != 0)
			return false;
		
		int initialNum = num, half = 0, mul = 1, newNum;
		
		digits /= 2;
		while(digits > 0)
		{
			half += mul * (num % 10);
			mul *= 10;
			num /= 10;
			digits--;
		}
		
		newNum = (int) Math.pow(num + half, 2);
		
		if(newNum == initialNum)
			return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		int num = sc.nextInt();
		
		if(isTechNumber(num))
			System.out.println(num + " is a tech number");
		else
			System.out.println(num + " is not a tech number");
	}
}
