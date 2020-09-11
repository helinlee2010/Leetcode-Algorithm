/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Recursion, DFS, fast O(N), extra space needed for stack (tree height) under the hood
class Solution {
    public int maxDepth(TreeNode root){
        if(root==null) {return 0;}
        int depth = Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
        return depth;
    }
}
 
// BFS slower, extra space for queue
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){ return 0; }
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        int depth = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            depth ++;
        }
        return depth;
    }
}

// My second visit, with Recursion helper function
public static int maxDepth(TreeNode root){
    if(root==null) return 0;
    return helper(root, 1);
}
private static int helper(TreeNode root, int depth){
    if(root==null) return depth-1;
    depth = Math.max(helper(root.left,depth +1), helper(root.right, depth+1));
    return depth;
}
