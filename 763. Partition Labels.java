// Time：O(N) Space: O(N)
class Solution {
    public List<Integer> partitionLabels(String S) {
        //Map<Character, Integer> map = new HashMap<>(); //用Array快很多
        int [] lastPosition = new int[26];
        
        // Traverse and record the last occurance of each char
        for(int i=0; i<S.length();i++){
            char ch = S.charAt(i);
            //map.put(ch, i);
            lastPosition[ch-'a'] = i;
        }
        
        List<Integer> result = new ArrayList<>();
        
        int i = 0;
        while(i<S.length()){
            // int chopIdx = map.get(S.charAt(i));
            int chopIdx = lastPosition[S.charAt(i)-'a'];
            
            for(int j=i+1; j<chopIdx; j++){
                //int lastOccurrence = map.get(S.charAt(j));
                int lastOccurrence = lastPosition[S.charAt(j)-'a'];
                
                if(lastOccurrence > chopIdx){
                    chopIdx = lastOccurrence;
                }   
            }
            result.add(chopIdx - i+1);
            i = chopIdx + 1;
        }   
        return result;
    }
}
