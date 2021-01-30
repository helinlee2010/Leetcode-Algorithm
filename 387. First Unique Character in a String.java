Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
Examples:
  s = "leetcode"
  return 0.
  
  s = "loveleetcode"
  return 2.
Note: You may assume the string contains only lowercase English letters.

// Approach 1: Frequency
public int firstUniqChar(String s) {
	if (s==null || s.length()==0) return -1;
	int len = s.length();
	if (len==1) return 0;
	
	char[] ch = s.toCharArray();
	
	// only lowercase letter
	int[] counts = new int[26];
	
	for(char c : ch){
		counts[c-'a'] ++;
	}
	
	for(int i = 0; i<len; i++){
		if(counts[ch[i]-'a']==1) return i;
	}
	
	return -1;
}

// Approach 2: Slow & fast pointer
public int firstUniqChar(String s) {
	if(s==null || s.length()==0) return -1;
	char[] chs=s.toCharArray();
	int[] count=new int[256];
	
	int slow = 0,fast = 0;
	
	int len = chs.length;
	while (fast < len){
		// fast pointer scanning ahead, update the count
		count[chs[fast]]++;
		
		// slow pointer keeps track of the unique 
		while(slow<len && count[chs[slow]]>1){
			slow++;
		}
		if (slow==len) return -1;
		
		fast++;
	}
	return slow;
}
