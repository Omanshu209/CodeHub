import java.util.Scanner;

public class PalindromeChecker
{
	public static int reverseNum(int num)
	{
		int reverse = 0;
		
		for(int i = 1 ; num > 0 ; i *= 10)
		{
			reverse *= 10;
			reverse += num % 10;
			num /= 10;
		}
		
		return reverse;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		int num = sc.nextInt();
		
		if(reverseNum(num) == num)
			System.out.println(num + " is a palindrome!");
		
		else
			System.out.println(num + " is not a palindrome!");
	}
}
