https://leetcode.com/problems/top-k-frequent-words/

// Use: PriorityQue & HashMap
// Time complexity: O(NlogK) from HashMap & PriorityQueue
// Space Complexity: O(N) from HashMap

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Create hashmap to store word and its frequency
        Map<String, Integer> hashmap = new HashMap<>();
        // Count the frequency & update the hashmap with for-loop
        for(String word: words){
            // If a word(key) is already in the map with a value
            // : increment this value by 1
            // If word is not present in map yet: init the value as 0 & add 1
            hashmap.put(word, hashmap.getOrDefault(word, 0)+1 ); 
        }
        
        // Create a Priority Queue with custom comparator
        
        // PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> (freq1-freq2));
        
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String w1, String w2){
                int freq1 = hashmap.get(w1);
                int freq2 = hashmap.get(w2);
                
                if(freq1 == freq2){
                    return w2.compareTo(w1);
                }
                /*****/
                return freq1 - freq2;
            }
        });
        
        // Insert into priority queue while maintaining only K elements in pq
        for(Map.Entry<String, Integer> entry: hashmap.entrySet()){
            pq.offer(entry.getKey());
            if(pq.size()>k){
                pq.poll();
            }
        } 
        
        // Create an array for storing result 
        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        Collections.reverse(result);
        return result;        
    }
}
