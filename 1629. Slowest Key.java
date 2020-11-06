The tester wants to know the key of the keypress that had the longest duration. The ith keypress had a duration of releaseTimes[i] - releaseTimes[i - 1], and the 0th keypress had a duration of releaseTimes[0].


Input: releaseTimes = [9,29,49,50], keysPressed = "cbcd"
Output: "c"

Input: releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
Output: "a"

public char slowestKey(int[] releaseTimes, String keysPressed){
	
	int max = releaseTimes[0];
	char[] keys = keysPressed.toCharArray();
	char slowest = keys[0];
	
	for(int i=1; i< keys.length; i++){
		int time = releaseTimes[i] - releaseTimes[i-1];
		if(time > max){
			max = time;
			slowest = keys[i];
		}
		if(time == max && keys[i] - slowest>0){
			max = time; 
			slowest = keys[i];
		}
	}
	return slowest;
}
