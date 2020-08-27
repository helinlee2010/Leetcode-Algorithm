// Approach: HashMap & Sorted ArrayList
// Time: O(nlogn) in worst case

Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

Example 1:
Input: arr = [5,5,4], k = 1
Output: 1

Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2


class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: arr){
            map.put(num, 1 + map.getOrDefault(num, 0));
        }
        
        List<Integer> freqList = new ArrayList<>(map.values());
        // Worst case: O(nlogn)
        Collections.sort(freqList);
        int elementCleared = 0;
        for(int freq: freqList){
            k = k - freq;
            
            if(k < 0) break;
            
            elementCleared++;
        
            /* after reduction, if k still > 0, one element is cleared
            continue removing on next element */
            // if k=0, last element just got cleared
            // after reduction, if k < 0, break the loop, finish      
        }
        return map.size()-elementCleared;
    }
}
