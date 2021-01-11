   // Dijkstra Algorithm

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // Build graph: adjacency matrix
        int[][] g = new int[n][n];
        
        for(int[] f : flights){
            int start = f[0];
            int end = f[1];
            int price = f[2];
            g[start][end] = price;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,src,K+1});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currPrice = curr[0];
            int currPoint = curr[1];
            int stepsRemain = curr[2];
            
            // if this point is destination, finish
            if(currPoint == dst) return currPrice;
            
            if(stepsRemain >0){
                // Add all reachable neighbors
                for(int i=0; i<n; i++){
                    if(g[currPoint][i] != 0){
                        int nextPrice = g[currPoint][i];
                        pq.offer(new int[]{currPrice+nextPrice, i, stepsRemain-1});
                    }
                }       
            }    
        }
        return -1;
    }
