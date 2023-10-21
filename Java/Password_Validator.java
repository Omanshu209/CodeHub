/*
Question

W.A.P. that takes in a string as input and evaluates it as a valid password. The password is valid if it has at a minimum 2 numbers, 2 of the following special characters ('!', '@', '#', '$', '%', '&', '*'), and a length of at least 7 characters.
If the password passes the check, output 'Strong', else output 'Weak'.
*/

import java.util.Scanner;

public class Password_Validation
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine(), password_strength = "Weak";
        
        if(password.length() >= 7)
        {
            char[] special_characters = {'!', '@', '#', '$', '%', '&', '*'};
            int num_count = 0, special_char_count = 0;
            
            for(char ch : password.toCharArray())
            {
                if((int)ch >= 48 && (int)ch <= 57)
                    num_count++;
                
                else
                    for(char sp_char : special_characters)
                        if(ch == sp_char)
                            special_char_count++;
            }
            
            if(num_count >= 2 && special_char_count >= 2)
                password_strength = "Strong";
        }
        
        System.out.println(password_strength);
    }
}
