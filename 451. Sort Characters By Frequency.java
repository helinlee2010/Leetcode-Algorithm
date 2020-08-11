https://leetcode.com/problems/sort-characters-by-frequency/

// Similar to 692, 347 
// Use: PriorityQueue & Hashmap & StringBuilder
// TimeComplexity: O(NlogN)
// Space Complexity: O(N)?

class Solution {
    public String frequencySort(String s) {
        
        if(s==null || s.length()<=2) {return s;}
        
        Map<Character, Integer> hashmap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0)+1 );
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>(){
            @Override
            public int compare(Character c1, Character c2){
                int freq1 = hashmap.get(c1);
                int freq2 = hashmap.get(c2);
                return freq2- freq1;
            }
        });
        
        //OR for short
        //PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> hashmap.get(b) - hashmap.get(a));
        
        for(Map.Entry<Character, Integer> entry: hashmap.entrySet()){
            pq.offer(entry.getKey());
        }
        
        StringBuilder sb = new StringBuilder("");
        while(!pq.isEmpty()){
            char curr = pq.poll();
            for(int i=0;i<hashmap.get(curr); i++){
                sb.append(curr);
            }   
        }
        return sb.toString();  
    }
}
