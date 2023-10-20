/*
W.A.P. that takes in a string that contains a sentence, checks if the first letter of each word is the same as the last letter of the previous word. If the condition is met, output true, if not, output false. 
Casing does not matter.
*/

import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        boolean output = true;
        
        for(int i = 1 ; i < words.length ; i++)
        {
            if(words[i].toLowerCase().charAt(0) != words[i - 1].toLowerCase().charAt(words[i - 1].length() - 1))
            {
                output = false;
                break;
            }
        }
        
        System.out.println(output);
    }
}
