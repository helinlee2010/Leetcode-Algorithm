// Dynamic Programming
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.


public int maxSubArray(int[] nums) {
	if(nums.length == 0) return 0;
	if(nums.length ==1) return nums[0];
	
	int len = nums.length;
	int[] dp = new int[len];
	
	dp[0] = nums[0];
	int maxSum = dp[0];
	
	for(int i = 1; i<len; i++){ 
		// Compare: Sum ends at index i & Sum starts at i (Discard previous)
		dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
		if(dp[i] > maxSum) maxSum = dp[i];
	}
	
	return maxSum;
}
