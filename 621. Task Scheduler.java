Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

Examples:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A


public int leastInterval(char[] tasks, int n) {
	// Corner case
	if(n==0) return tasks.length;
	int[] freq = new int[26];
	for(char ch: tasks){
		freq[ch - 'A']++;
	}
	Arrays.sort(freq);
	
	int max_freq = freq[25];
	int space = (max_freq-1) * (n+1); 
	
	int extra = 0;
	for(int i = 24; i >= 0 && freq[i]>0; i--){
		if(freq[i] > (max_freq-1)){
			extra++;
		}
	}
	return Math.max(tasks.length, extra + space + 1);
}
