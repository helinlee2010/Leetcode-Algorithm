// Need to create a new array to store the position-adjusted nums, then switch it back to original array
// Time: O(N) Space: O(N)
class Solution {
    public void rotate(int[] nums, int k) {
        int[] copy = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int newIndex = (i+k) % nums.length;
            copy[newIndex] = nums[i];
        }
        for(int i=0; i<copy.length; i++){
            nums[i] = copy[i];
        }
    }
}

// Optimization 
// Improve it to Space: O(1) in-place

    //Time: O(N) Space: O(1)
    public void rotate(int[] nums, int k){
        int len = nums.length;
        //In case of k>nums.len
        k = k % len;
        
        // Reverse 3 times
        // Firstly: reverse the whole
        reverse(nums, 0, len-1);
        // Secondly: reverse first half
        reverse(nums, 0, k-1);
        // Thirdly: reverse right half
        reverse(nums, k, len-1);
        
    }
    public void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            /* !!! */
            start++;
            end--;
        }
    }
