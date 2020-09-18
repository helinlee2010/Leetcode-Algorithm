arr = A B C D E, steps = 2 (counting from the starter)(start at index 0 at the very beginning)
A C D E
A C E
C E
C
At the end, return C

//Using Array 

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
