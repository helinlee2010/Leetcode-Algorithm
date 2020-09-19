arr = A B C D E, steps = 2 (counting from the starter)(start at index 0 at the very beginning)
A C D E
A C E
C E
C
At the end, return C

// 1. Using LinkedList
public static void josephus(char[] charArr, int steps){
	LinkedList<Character> list = new LinkedList<>();
	for(char ch: charArr){
		list.add(ch);
	}
	
	int killer = 0;
	int total = list.size();
	
	while(total > 1){
		int killed = killedIdx(total, killer, steps);
		list.remove(killed);
		System.out.println(list.toString());
		killer = killed + 1;
		total = list.size(); 
	}
}

private static int killedIdx(int total, int killerIdx, int steps){
	if(total == 1) return -1; // winner, no one should be killed
	return (killerIdx + steps - 1)%total; 
}

public static void main(String[] args) {
	char[] input = {'A', 'B','C', 'D', 'E'};
	josephus(input, 2);
}



// 2. Using Array, to find the final winner only

public static char josephus(char[] input, int steps){
	int len = input.length;
	int winnerIdx = recursive(len,steps);
	return input[winnerIdx];
}

public static int recursive(int length, int steps){
	// Output is the index of winner 
	// Base case
	if(length == 1) return 0;
	return (recursive(length-1, steps) + steps) % length;
}
public static void main(String[] args) {
	char[] input = {'A', 'B', 'C', 'D', 'E'};
	int steps = 2;
	char result = josephus(input, steps);
	System.out.println(result);
}
