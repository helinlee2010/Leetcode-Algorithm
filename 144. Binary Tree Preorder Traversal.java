https://leetcode.com/problems/binary-tree-preorder-traversal/

// Iterative Approach: Stack with right children only

public List<Integer> preorderTraversal(TreeNode root) {
	List<Integer> result = new LinkedList<>();
	Deque<TreeNode> rights = new LinkedList<>();
	// LinkedList allow null, but ArrayDeque not allow
	// Thus, cannot use ArrayDeque, must use LinkedList here
	
	TreeNode curr = root;
	while (curr != null || !rights.isEmpty()) {
		if(curr != null){
			result.add(curr.val);
			
			rights.push(curr.right);
			
			// update the curr to its left
			curr = curr.left;
			
		}else{ 
		//curr == null && !rights.isEmpty()
			
			curr = rights.pop();
			
		}
	}
	return result;
}

