using System;

namespace Code
{
    public class Program
    {
        public static int factorial(int num)
        {
            int val = 1;
            
            for(;num > 1;num = num - 1)
            val = val * num;
            
            return val;
        }
        
        public static void Main(string[] args)
        {
            Console.Write("Enter a number : ");
            int num = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine($"The factorial of {num} is {factorial(num)}");
        }
    }
}
