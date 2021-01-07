
// Prim's Algo for Minimum Spanning Tree (MST)
// Alternatively, can use Kruskal's Algo for MST

public int minCostConnectPoints(int[][] points) {
	int n = points.length;
	boolean[] visited = new boolean[n];

	// Start with point 0
	visited[0] = true;

	// Create PQ/minHeap based on distance
	PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
	// Dummy
	// pq.offer(new int[]{0,0});

	// Init result variable
	int cost = 0;
	// Start with point 0
	int curr = 0;
	int connected = 1;

	// increment before evaluating
	while(++connected<=n) {
		// Loop through this point's neighbors
		for (int k = 1; k < n; k++) {
			if (!visited[k]) {
				// PQ storing: [distFromCurrPoint, endPointIdx]
				pq.add(new int[]{Math.abs(points[k][0] - points[curr][0]) + Math.abs(points[k][1] - points[curr][1]), k});
			}
		}

		while (visited[pq.peek()[1]]){
			pq.poll();
		}

		// if(!pq.isEmpty())
		int[] next = pq.poll();
		visited[next[1]] = true;
		curr = next[1];
		cost += next[0];
	}
	return cost;
}
