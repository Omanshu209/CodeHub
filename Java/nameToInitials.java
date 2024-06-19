import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Name : ");
		String name = sc.nextLine();
		
		int spaces = 0;
		for(int i = 0 ; i < name.length() ; i++)
			if(name.charAt(i) == ' ')
				spaces++;
		
		String[] words = new String[spaces + 1];
		
		int index = 0;
		String word = "";
		
		for(int i = 0 ; i < name.length() ; i++)
		{
			char ch = name.charAt(i);
			
			if(ch == ' ')
			{
				words[index] = word;
				index++;
				word = "";
				continue;
			}
			
			word += ch;
		}
		
		words[index] = word;
		
		String initials = "";
		
		for(int i = 0 ; i < words.length - 1 ; i++)
			initials += words[i].charAt(0) + ". ";
		
		initials += words[words.length - 1];
		
		System.out.println(initials);
	}
}
