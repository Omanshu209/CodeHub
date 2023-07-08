import java.util.Scanner;

public class Prime
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		boolean prime = true;
		System.out.print("Enter the number : ");
		int num = sc.nextInt();
		
		for(int i = num - 1;i > 1;i--)
		{
			if(num % i == 0)
			{
				prime = false;
				break;
			}
		}
		
		if(prime)
		System.out.println(num + " is a prime number");
		
		else
		System.out.println(num + " is not a prime number");
	}
}