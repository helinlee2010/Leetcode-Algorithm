// Dynamic Programming
// Time & Space: O(N) 
// dp[n] to store the max accumulative money you can get at each house
// For a house, 2 choices
  // 1. Take the money, if previous wasn't robbed. dp[i-2]+nums[i]
  // 2. Skip it, dp[i-1]
// At each house, best: Math.max( dp[i-2]+nums[i], dp[i-1])


public int rob(int[] nums) {
      int len = nums.length;
      if(len == 0) return 0;
      if(len ==1) return nums[0];

      int[] dp = new int[len];
      dp[0] = nums[0];
      dp[1] = Math.max(nums[1], dp[0]);

      for(int i=2; i<len; i++){
          // max money obtained so far
          dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
      }
      return dp[len-1];
}
