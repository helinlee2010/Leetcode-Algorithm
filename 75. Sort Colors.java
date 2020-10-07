75. Sort Colors (Medium)
https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        // head: put 0
        int p = 0;
        // tail: put 2
        int k = nums.length -1;
        // scanning pointer
        int q = 0;
        while(q<=k){
            if(p<q && nums[q] == 0){
                swap(nums, p, q);
                p++;
            }else if(nums[q] == 2){
                swap(nums, q, k);
                k--;
            }else{
                q++;
            }
        }
    }
    private void swap(int[] nums,int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
