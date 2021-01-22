// Stack (ArrayDeque)
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

// Time & Space: O(N)
public int[] dailyTemperatures(int[] T) {
	int len = T.length;
	int[] result = new int[len];
	
	Deque<Integer> stack = new ArrayDeque<>();
	// Stack storing the index! 
	// Representing descending temp from bottom to top
	
	// Only loop once
	for(int i = 0; i<len; i++){
		int currTemp = T[i];
		while(!stack.isEmpty() && currTemp > T[stack.peek()]){
			int idx = stack.pop();
			result[idx] = i - idx;
		}
		stack.push(i);
	}
	return result;
}


// Brute-force O(N^2)
public int[] dailyTemperatures(int[] T) {
	// Brute-force approach
	int len = T.length;
	int[] result = new int[len];
	
	// Nested loops
	for(int i = 0; i<len; i++){
		int currTemp = T[i];
		for(int j=i+1; j<len; j++){
			if(T[j] > currTemp){
				// ans for this index
				result[i] = j - i;
				break;
			}
		}
	}
	return result;
}
