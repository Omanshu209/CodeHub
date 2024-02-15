import java.util.Scanner;

public class arrangeNum
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = 10, sum = 0;
		
		while(!(Math.floor(Math.log10(Math.abs(n))) >= 2))
		{
			System.out.print("Number = ");
			n = sc.nextInt();
		}
		
		String numStr = "";
		while(n > 0)
		{
			numStr += n % 10;
			sum += n % 10;
			n /= 10;
		}
		
		for(int i = 0 ; i < numStr.length() - 1 ; i++)
		{
			for(int j = 0 ; j < numStr.length() - i - 1 ; j++)
			{
				if((int) numStr.charAt(j) > (int) numStr.charAt(j + 1))
					numStr = numStr.substring(0, j) + numStr.charAt(j + 1) + numStr.charAt(j) + numStr.substring(j + 2);
			}
		}
		
		System.out.println("Sum = " + sum + "\nArranged Num = " + numStr);
	}
}
