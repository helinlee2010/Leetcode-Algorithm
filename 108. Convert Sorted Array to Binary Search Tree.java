https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
// Time : O(N)

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // Error Check
        if(nums == null || nums.length == 0) return null;
        
        return constructBST(nums, 0, nums.length-1);
    }
    
    private TreeNode constructBST(int[] nums, int left, int right){
        //Recursion Base Case,where we're done, reach out of the boundary
        if(right < left){
            return null;
            
        }else{  //right >=left
            
            int mid = left + (right - left)/2;
            TreeNode root = new TreeNode(nums[mid]);

            root.left = constructBST(nums, left, mid-1);
            root.right = constructBST(nums, mid+1, right); 
            return root;
        }
    }
}
