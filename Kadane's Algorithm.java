// Kadane's algorithm 
// Maximum sum from contiguous subarray

// Given an array, return the maximum sum of contiguous subarray
// Time complexity: O(n)
class Solution{

    public int maxSumSubarray(int[] arr){
        // Initiate a subarray start at first element
        // It also ends at first element, so initial maxSum is arr[0] itself
        int maxSumHere = arr[0]
        int maxSoFar = arr[0]

        // Move forward the start position of subarray
        // while comparing & updating the best result/sum
        for(int i=0; i<arr.length;i++){
            // Ask: should a start a new subarray or extend from previous one?
            // (What is the max sum I can achieve if the subarray ends at arr[i]?)
            maxSumHere = Math.max(arr[i], arr[i]+maxSumHere);

            // Update the max sum so far if it's greater than the record
            maxSoFar = Math.max(maxSumEnd, maxSoFar);
        } 

        return maxSoFar;
    } 
}
