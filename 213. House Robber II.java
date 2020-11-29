// Time O(N)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0], nums[1]);
        
        int startFirst = bestResult(nums, 0, len-2);
        int startSecond = bestResult(nums, 1, len-1);
        
        return Math.max(startFirst, startSecond);
    }
    
    private int bestResult(int[] nums, int start, int end){
        if(start == end) return nums[start];
        
        int len = end - start + 1;
        if(len == 2) return Math.max(nums[start], nums[end]);
        
        int[] dp = new int[len];
        
        //***
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);
        
        for(int i=2; i<len; i++){
            dp[i] = Math.max(dp[i-2]+nums[start+i], dp[i-1]);
        }
        return dp[len-1];
    }
}
