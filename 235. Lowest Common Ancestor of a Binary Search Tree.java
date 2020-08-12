https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Recursion 
// Time: O(N)   Space: O(H) height of the tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){return null;}
        if(root.val==p.val || root.val== q.val){
            return root;
        }
        TreeNode leftSearchRes = lowestCommonAncestor(root.left, p, q);
        // will return the target node(s) if found
        TreeNode rightSearchRes = lowestCommonAncestor(root.right, p, q);
        
        if(leftSearchRes == null){
            return rightSearchRes;
        }
        if(rightSearchRes==null){
            return leftSearchRes;
        }
        // If both target found in this root's left & right subtree (none is null)           // then this root is the LCA
        return root;
    }
}
