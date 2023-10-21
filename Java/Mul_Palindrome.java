/*
Question

You work in a sign factory, and the machine has started printing all of the signs backwards! The signs have already been packed into boxes of four signs each. Every letter on every sign is capitalized, so if the original sign was of a palindrome (a word or phrase that is the same backwards and forwards) you can still save those signs and not have to reprint them.

Given the four words that were supposed to be contained in each box, determine if at least one of them is of a palindrome.
Print a string that say 'Open' if at least one of the boxes is a palindrome or 'Trash' if all of the signs are misprinted.
*/

import java.util.Scanner;

public class Program
{
    static boolean isPalindrome(String word)
    {
        String new_word = "";
        
        for(int i = word.length() - 1 ; i >= 0 ; i--)
            new_word += word.charAt(i);
        
        if(word.equals(new_word))
            return true;
        
        else
            return false;
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] words = {sc.next(), sc.next(), sc.next(), sc.next()};
        String status = "Trash";
        
        for(String word : words)
            if(isPalindrome(word))
            {
                status = "Open";
                break;
            }
        
        System.out.println(status);
    }
}
