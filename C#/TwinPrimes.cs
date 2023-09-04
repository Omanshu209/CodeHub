using System;

namespace Program
{
    public class TwinPrime
    {
        public static bool IsPrime(System.Int32 num)
        {
            for(int i = 2;i <= Math.Sqrt(num);i++)
            {
                if(num % i == 0)
                    return false;
            }
            
            return true;
        }
        
        public static void Main(string[] args)
        {
            Console.Write("Number 1 : ");
            int num1 = Convert.ToInt32(Console.ReadLine());
            
            Console.Write("Number 2 : ");
            int num2 = Convert.ToInt32(Console.ReadLine());
            
            if(IsPrime(num1) && IsPrime(num2) && Math.Abs(num1 - num2) == 2)
                Console.WriteLine($"{num1} and {num2} are Twin Prime Numbers!");
            
            else
                Console.WriteLine($"{num1} and {num2} are not Twin Prime Numbers!");
        }
    }
}
