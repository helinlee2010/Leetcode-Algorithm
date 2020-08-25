//Time: O(N) Space: O(N) in worst case

public class Solution {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            this.val = x;
        }
    }
    public static int longestConsecutiveLen(TreeNode root){
        if(root == null) return 0;
        // the value of an integer is immutable, so use int[] instead
        int[] max = new int[1];
        recursiveCall(root, 1, max);
        return max[0];
    }
    public static void recursiveCall(TreeNode root, int count, int[] max){
        if(root == null) return;
        max[0] = Math.max(max[0], count);
        if(root.left != null){
            if(root.left.val == root.val+1){
                count++;
                recursiveCall(root.left, count, max);
            }else{
                recursiveCall(root.left, 1, max);
            }
        }
        if(root.right != null){
            if(root.right.val == root.val+1){
                count++;
                recursiveCall(root.right, count, max);
            }else{
                recursiveCall(root.right, 1, max);
            }
        }        
    }
    
    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.right = new TreeNode(3);
        // r.right.right = new TreeNode(3);
        r.right.right = new TreeNode(4);
        r.right.left = new TreeNode(2);
        r.right.right.right = new TreeNode(5);
        r.right.left.left = new TreeNode(1);
        
        int result = longestConsecutiveLen(r);
        System.out.println(result);
        
    }
}
