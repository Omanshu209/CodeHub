/*
Question

W.A.P. that takes in a string that has camel casing, and outputs the same string but with snake casing.
*/

import java.util.Scanner;

public class CamelToSnake
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String camelCased = sc.next(), snake_cased = "";
        
        for(int i = 0 ; i < camelCased.length() ; i++)
        {
            if(camelCased.toUpperCase().charAt(i) == camelCased.charAt(i) && i != 0)
            {
                snake_cased += "_" + camelCased.toLowerCase().charAt(i);
                continue;
            }
            snake_cased += camelCased.toLowerCase().charAt(i);
        }
        
        System.out.println(snake_cased);
    }
}
