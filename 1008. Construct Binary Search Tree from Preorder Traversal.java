// Given an array of preorder traversal sequence, construct a Binary Search Tree
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

// Time: O(N)
class Solution {
    // Global Variable 
    int idx = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, Integer.MAX_VALUE);
    }
    public TreeNode construct(int[] preorder, int limit){
        if(idx == preorder.length || preorder[idx]> limit) return null;
        
        int currNum = preorder[idx];
        TreeNode curr = new TreeNode(currNum);
        idx++;
        curr.left = construct(preorder, currNum);
        curr.right = construct(preorder, limit);
        return curr;
    }
}
