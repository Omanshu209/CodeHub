public class sorting
{
	private static int[] bubbleSort(int[] arr)
	{
		for(int i = 0 ; i < arr.length - 1 ; i++)
		{
			for(int j = 0 ; j < arr.length - 1 - i ; j++)
			{
				// '>' - ascending, '<' - descending
				if(arr[j] > arr[j + 1])
				{
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		
		return arr;
	}
	
	private static int[] selectionSort(int[] arr)
	{
		for(int i = 0 ; i < arr.length - 1 ; i++)
		{
			int index = i;
			
			for(int j = i ; j < arr.length ; j++)
				// '<' - ascending, '>' - descending
				if(arr[j] < arr[index])
					index = j;
			
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		
		return arr;
	}
	
	private static int[] insertionSort(int[] arr)
	{
		for(int i = 1 ; i < arr.length ; i++)
		{
			int index = i;
			for(int j = i - 1 ; j >= 0 ; j--)
			{
				// '>' - ascending, '<' - descending
				if(arr[index] >= arr[j])
					break;
				
				else
				{
					int temp = arr[index];
					arr[index] = arr[j];
					arr[j] = temp;
					
					index = j; 
				}
			}
		}
		
		return arr;
	}
	
	private static void printArray(int[] arr)
	{
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + "  ");
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		/*
		int[] arr = {3, 2, 9, 34, 12, 1};
		
		//int[] sortedArr = bubbleSort(arr);
		//int[] sortedArr = selectionSort(arr);
		//int[] sortedArr = insertionSort(arr);
		
		printArray(sortedArr);
		*/
	}
}
