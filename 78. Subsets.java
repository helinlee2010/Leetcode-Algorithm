https://leetcode.com/problems/subsets/
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.


Time: O(2^N)
Space: O(N)

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        recursive(nums, 0, subset, result);
        return result;
    }
    
    public void recursive(int[] nums, int start, List<Integer> subset, List<List<Integer>> result){
        // Firstly, add the current subset into result
        result.add(new ArrayList(subset));
        
        // this is not necessary
        // if(start == nums.length) return;
        
        for(int i=start; i<nums.length; i++){
            // Include this num(at index start)
            subset.add(nums[i]);
            // Do the same for numbers after it, by recursion
            recursive(nums, i+1, subset, result);
            // Exclue this num(at index start)
            subset.remove(subset.size()-1);
        }
    }
}
