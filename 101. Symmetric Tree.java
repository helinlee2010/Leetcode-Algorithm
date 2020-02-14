(Level: Easy) (Concept: BFS)
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
   
//Iterative Solution:

//Definition for a binary tree node.
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()){
          TreeNode leftSubtree = q.poll();
          TreeNode rightSubtree = q.poll();
          if (leftSubtree==null && rightSubtree==null) return true;
          if (leftSubtree==null || rightSubtree==null) return false;
          if (leftSubtree.val != && rightSubtree.val) return false;
          q.add(leftSubtree.left);
          q.add(rightSubtree.right);
          q.add(leftSubtree.right);
          q.add(rightSubtree.left);
        }
    }
}
