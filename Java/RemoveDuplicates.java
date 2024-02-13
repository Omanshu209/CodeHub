/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k
*/

class Solution
{
    public int removeDuplicates(int[] nums)
    {
        int[] uniqueNums = new int[nums.length];
        int unique = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            boolean isUnique = true;
            for(int j = 0 ; j < unique ; j++)
                if(nums[i] == uniqueNums[j])
                    isUnique = false;
            
            if(isUnique)
            {
                uniqueNums[unique] = nums[i];
                unique++;
            }
        }
        
        for(int i = 0 ; i < unique ; i++)
            nums[i] = uniqueNums[i];

        return unique;
    }
}
