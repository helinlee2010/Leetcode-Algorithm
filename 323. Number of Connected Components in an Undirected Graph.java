Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
Example 1:
     0             3
     |             |
     1 --- 2       4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

// Union Find with path compression
// Time: O(n+Elog(n))  E:# of edges

public int countComponents(int n, int[][] edges){
    // Parent mapping
    int[] parents = new int[n];

    // Initially, all nodes' parents are themselves
    for(int i=0; i<n; i++){
        parents[i] = i;
    }

    // Union (Merge)
    for(int[] edge : edges){
        union(edge[0], edge[1], parents);
    }

    // Count & return the unique parents 
    Set<Integer> unique = new HashSet<>();
    for(int i=0; i<parents.length; i++){
        // unique.add(parents[i]); //will this work?

        unique.add(find(i,parents));
    }
    return unique.size();
	}
	
	private void union(int node1, int node2, int[] parents){
      int parent1 = find(node1, parents);
      int parent2 = find(node2, parents);
      parents[node1] = parent2;
	}
	
	// Find w/ Path compression
	private int find(int node, int[] parents){
      if(parents[node] == node) return node;

      parents[node] = find(parent[node], parents);
      return parents[node];
	}

