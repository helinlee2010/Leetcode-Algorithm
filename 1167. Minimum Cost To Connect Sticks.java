// Level: Medium

class Solution {
	public int minCostToConnectSticks(int [] sticks){
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int stick: sticks){
			minHeap.add(stick);
		}
		
		int cost = 0;
		
		while(minHeap.size()>1){
			int firstMin = minHeap.poll();
			int secondMin = minHeap.poll();
			int newStick = firstMin + secondMin;
			cost += newStick;
			minHeap.add(newStick);
		}
		//when exit this loop, what's left is 
		//just the final longest stick that we combined
		
		return cost;
	}
}
