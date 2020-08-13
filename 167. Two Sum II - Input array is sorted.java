https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

// Level: Easy

/* Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. */

// O(N) 100%
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length ==0 ) {return null;}
        
        int[] result = new int[2]; 
        int left = 0;
        int right = numbers.length - 1;
        
        while(left < right){
            int sum = numbers[left] + numbers [right];
            
            if(sum > target){
                right --;
            }
            if (sum < target){
                left ++;
            }
            if(sum == target){
                result[0] = left+1;
                result[1] = right+1;
                break; /**!**/
            }
        }
        return result;  
    }
}
