using System;

namespace Program
{
    public class MultiplicationTable
    {
        public static void Main(string[] args)
        {
            Console.Write("Enter a number : ");
            double num = Convert.ToInt32(Console.ReadLine());
            
            for(int i = 1;i <= 10;i++)
            Console.WriteLine($"{num} x {i} = {num * i}");
        }
    }
}
