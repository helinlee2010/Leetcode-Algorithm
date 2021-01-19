 // Priority Queue
 
 public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int[] result = new int[k];
         
        Queue<Integer> q = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int num: nums){
            if(!visited.contains(num)){
                q.offer(num);
                visited.add(num);
            }
            if(q.size()>k){
                q.poll();
            }
            
        }
        
        for(int i=k-1; i>=0; i--){
            result[i] = q.poll();
        }
        
        return result;
   }
