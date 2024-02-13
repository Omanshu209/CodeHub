//Given an integer x, return true if x is a palindrome, and false otherwise.

class Solution
{
    public boolean isPalindrome(int x)
    {
        int reverseX = 0, x_initial = x;
        int mul = (int) Math.pow(10, Math.floor(Math.log10(x)));

        while(x > 0)
        {
            reverseX += (x % 10) * mul;
            mul /= 10;
            x /= 10;
        }

        if(x_initial == reverseX)
            return true;
        
        return false;
    }
}
