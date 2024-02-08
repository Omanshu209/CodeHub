import java.util.Scanner;

public class array
{
	private static void printArray(int[] arr)
	{
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + "  ");
		System.out.println();
	}
	
	private static int[] selectionSort(int[] arr, boolean ascending)
	{
		for(int i = 0 ; i < arr.length - 1 ; i++)
		{
			int index = i;
			
			for(int j = i ; j < arr.length ; j++)
			{
				if(ascending)
				{
					if(arr[j] < arr[index])
						index = j;
				}
				
				else
				{
					if(arr[j] > arr[index])
						index = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
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
		printArray(selectionSort(arr, true));
		
		System.out.print("Sorted Array (Descending) : ");
		printArray(selectionSort(arr, false));
	}
}
