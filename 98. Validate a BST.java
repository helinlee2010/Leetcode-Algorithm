Given a binary tree, determine if it is a valid binary search tree (BST).

// Recursive Solution

class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    // [2147483647], [2147483647,2147483647] - Corner Testcase (so use Long)
    public boolean helper(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max){
            return false;
        }
        return helper(root.left, min, root.val)
             && helper(root.right, root.val, max);
    }
}
