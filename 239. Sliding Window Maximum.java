// O(N)Time approach with ArrayDeque

class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0) return new int[0]; 
		int[] output = new int[nums.length - k + 1];
		
		ArrayDeque<Integer> ad = new ArrayDeque<>(); 
		
		for(int i = 0; i < nums.length; i++) {
			/* While sliding, discard the starting point of the previous window */
			if(!ad.isEmpty() && ad.peekFirst() == i - k) {
				ad.removeFirst(); 
			} 
			
			while(!ad.isEmpty() && nums[ad.peekLast()] < nums[i]) {
				ad.removeLast(); 
			}
			
			/* Add the new index to the end of the ArrayDeque */
			ad.offer(i); 
			
			/* For each new window, add the window maximum to the output */ 
			if(i >= k - 1) {
				output[i - k + 1] = nums[ad.peekFirst()]; 
			}
		}
		return output; 
	}
}


//Brute-Force Approach. Time:O(nk)?
class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;
		List<Integer> list = new ArrayList<>();
		
		int l = 0, r = l+k-1;
		
		while(l < len-k+1 && r < len){
			int max = Integer.MIN_VALUE;
			int currMax = max;
			
			for(int i = l; i <= r; i++){
				if(nums[i] > currMax){
					currMax = nums[i];
				}
			}
			
			list.add(currMax);
			l++;
			r++;
		}
		
		int[] res = new int[len-3+1];
		
		// Convert list to int[ ]
		for(int i=0; i<res.length; i++){
			res[i] = list.get(i);
		}
		return res;
	}
}
