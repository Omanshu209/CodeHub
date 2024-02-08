import java.util.Scanner;

public class array
{
	private static void printArray(int[] arr)
	{
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + "  ");
		System.out.println();
	}
	
	private static int[] bubbleSort(int[] arr, boolean ascending)
	{
		for(int i = 0 ; i < arr.length - 1 ; i++)
		{
			for(int j = 0 ; j < arr.length - i - 1 ; j++)
			{
				if(ascending)
				{
					if(arr[j] > arr[j + 1])
					{
						int temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
				
				else
				{
					if(arr[j] < arr[j + 1])
					{
						int temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}	
		}
		
		return arr;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Size : ");
		int size = sc.nextInt();
		
		int[] arr = new int[size];
		
		System.out.println("\nElements : ");
		
		// Collecting The Elements
		for(int i = 0 ; i < size ; i++)
			arr[i] = sc.nextInt();
		
		System.out.print("\nUnsorted Array :            ");
		printArray(arr);
		
		System.out.print("Sorted Array (Ascending) :  ");
		printArray(bubbleSort(arr, true));
		
		System.out.print("Sorted Array (Descending) : ");
		printArray(bubbleSort(arr, false));
	}
}
