You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Dynamic Programming, Fibonacci
// Note: recursive calls may TLE

public int climbStairs(int n) {
	// Error Check, avoid null pointer exception later
	if(n == 0) return 0;
	if(n == 1) return 1;
	if(n == 2) return 2;
	
	// Create an array storing: for idx steps, how many ways it has
	int[] ways = new int[n+1];
	
	ways[0] = 0;
	ways[1] = 1;
	ways[2] = 2;
	
	for(int i=3; i<n+1; i++){
		ways[i] = ways[i-1] + ways[i-2]; 
	}
	
	return ways[n];
}
