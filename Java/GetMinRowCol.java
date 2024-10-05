import java.util.List;
import java.util.LinkedList;

public class GetMinRowCol
{
	public static int[] getMinRowCol(int num)
	{
		List<int[]> listOfFactors = new LinkedList<int[]>();
		
		for(int i = 1 ; i <= num ; i++)
		{
			if(num % i != 0)
				continue;
			else if(i == num / i)
				return new int[]{i, i};
			
			int[] factors = {i, num / i};
			listOfFactors.add(factors);
		}
		
		int[] outArr = {num, 1};
		int diff = num - 1;
		
		for(int[] arr : listOfFactors)
		{
			int numDiff = arr[0] - arr[1];
			
			if(numDiff > 0 && numDiff < diff)
			{
				outArr = arr;
				diff = numDiff;
			}
		}
		
		return outArr;
	}
	
	public static void main(String[] args)
	{
		int[] arr = getMinRowCol(68);
		System.out.println(arr[0] + "  " + arr[1]);
	}
}
