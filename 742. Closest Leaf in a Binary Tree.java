	// Time & Space: O(N)
  public class Solution {
	        // Global variable target node to start BFS
	        TreeNode start;
	        
	        public int findClosestLeaf(TreeNode root, int k) {
	                Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
	                Set<TreeNode> seen = new HashSet<>();
	                Queue<TreeNode> q = new LinkedList<>();
	                
	                // 根据Tree建立Undirected Graph
	                dfs(graph, root, null, k);
	                
	                //从start node开始BFS
	                q.add(start);
	                
	                // BFS 部分
	                while(!q.isEmpty()){
	                        TreeNode curr = q.poll();
	                        // 若当前node是leaf的话 即找到答案
	                        if(curr.left==null && curr.right==null) return curr.val;
	                        // 标记当前node为已访问
	                        seen.add(curr);
	                        // 把当前node的邻居加入到queue里
	                        for(TreeNode neighbor : graph.get(curr)){
	                                // 把还未访问过的邻居加入到queue里
	                                if(!seen.contains(neighbor)) q.add(neighbor);
	                        }
	                }
	                
	                // return a dummy number 实际不会运行到这里的
	                return 0;
	        }
	        public void dfs(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent, int k){
	                if(node == null) return;
	                // 建立graph是标记target node where its val==k
	                if(node.val == k) start = node;
	                
	                if(!graph.containsKey(node)) graph.put(node, new LinkedList<>());
	                if(!graph.containsKey(parent)) graph.put(parent, new LinkedList<>());
	                
	                if(parent != null){
	                        graph.get(node).add(parent);
	                        graph.get(parent).add(node);
	                }
	                // 继续建graph
	                dfs(graph, node.left, node, k);
	                dfs(graph, node.right, node, k);
	        }
	}
