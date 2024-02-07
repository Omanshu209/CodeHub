public class recursion
{
	private static String reverseString(String str, int length)
	{
		if(length == 0)
			return String.valueOf(str.charAt(0));
		return str.charAt(length) + reverseString(str, length - 1);
	}
	
	private static int[] occuranceOfChar(String str, char ch, int[] arr, int index)
	{
		if(index == -1)
			return arr;
		
		if(arr[0] == -1)
			if(str.charAt(str.length() - index - 1) == ch)
				arr[0] = str.length() - index - 1;
		
		if(arr[1] == -1)
			if(str.charAt(index) == ch)
				arr[1] = index;
		
		occuranceOfChar(str, ch, arr, index - 1);
		return arr;
	}
	
	private static boolean sortedArray(int[] arr, int index)
	{
		if(index == 0)
			return true;
		
		// '<' - ascending, '>' - descending
		if(arr[index] < arr[index - 1])
			return false;
		
		return sortedArray(arr, index - 1);
	}
	
	private static int count = 0;
	private static String newStr = "";
	private static String sepChars(String str, int index)
	{
		if(index == str.length() - 1)
		{
			for(; count > 0 ; count--)
				newStr += 'x';
			
			return newStr;
		}
		
		if(str.charAt(index) == 'x')
			count++;
		else
			newStr += str.charAt(index);
		
		return sepChars(str, index + 1);
	}
	
	//private static String newStr = "";
	private static String removeDuplicates(String str, int index)
	{
		if(index == str.length())
			return newStr;
		
		boolean isDuplicate = false;
		for(int i = 0 ; i < newStr.length() ; i++)
		{
			if(str.charAt(index) == newStr.charAt(i))
			{
				isDuplicate = true;
				break;
			}
		}
		
		if(!(isDuplicate))
			newStr += str.charAt(index);
		
		return removeDuplicates(str, index + 1);
	}
	
	private static void printSubsequences(String str, int index, String newStr)
	{
		if(index == str.length())
		{
			System.out.println(newStr);
			return;
		}
		
		printSubsequences(str, index + 1, newStr + str.charAt(index));
		printSubsequences(str, index + 1, newStr);
	}
	
	private static void printUniqueSubsequences(String str, int index, String newStr,String[] unique)
	{
		if(index == str.length())
		{
			for(int i = 0 ; i < unique.length ; i++)
			{
				if(newStr.equals(unique[i]))
					break;
				
				else if(unique[i] == null)
				{
					unique[i] = newStr;
					System.out.println(newStr);
					break;
				}
			}
			
			return;
		}
		
		printUniqueSubsequences(str, index + 1, newStr + str.charAt(index), unique);
		printUniqueSubsequences(str, index + 1, newStr, unique);
	}
	
	public static void main(String[] args)
	{
		/*
		String str = "hello";
		System.out.println(reverseString(str, str.length() - 1));
		*/
		
		/*
		String str = "csabsaaabsaab";
		char ch = 'a';
		int[] arr = {-1, -1};
		arr = occuranceOfChar(str, ch, arr, str.length() - 1);
		System.out.println(arr[0] + "  " + arr[1]);
		*/
		
		/*
		int[] arr = {1, 7, 6, 17, 19, 21};
		System.out.println(sortedArray(arr, arr.length - 1));
		*/
		
		/*
		String str = "axbxxcdxxxxe";
		System.out.println(sepChars(str, 0));
		*/
		
		/*
		String str = "abbcccdeddef";
		System.out.println(removeDuplicates(str, 0));
		*/
		
		/*
		String str = "abcde";
		printSubsequences(str, 0, "");
		*/
		
		/*
		String str = "aaaaaaaaaaa";
		String[] unique = new String[(int)Math.pow(2, str.length())];
		printUniqueSubsequences(str, 0, "", unique);
		*/
	}
}
