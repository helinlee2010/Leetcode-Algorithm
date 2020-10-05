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
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root==null) return result;
        
        StringBuilder path = new StringBuilder();
        buildPath(root, path, result);
        return result;
    }
    public void buildPath(TreeNode root, StringBuilder path, List<String> result){
        int len = path.length();
        if(len==0){
            path.append(String.valueOf(root.val));
        }else{
            path.append("->"+String.valueOf(root.val));
        }
        if(root.left == null && root.right == null){
            result.add(path.toString());
        }
        if(root.left != null){
            buildPath(root.left, path, result);
        }
        if(root.right != null){
            buildPath(root.right, path, result);
        }
        path.setLength(len);
    }
}
