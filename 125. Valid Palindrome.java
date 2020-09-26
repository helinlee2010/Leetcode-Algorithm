https://leetcode.com/problems/valid-palindrome/ 

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

public boolean isPalindrome(String s) {
	int len = s.length();
	if(len == 0) return true; 
	int i = 0;
	int j = len -1;
	
	while(i<j){
		//Move the pointer until it find a alphanumeric character
		while( i<j && !Character.isLetterOrDigit(s.charAt(i))){
			i++;
		}
		while( i<j && !Character.isLetterOrDigit(s.charAt(j))){
			j--;
		}
		
		// Convert the lowercase, use if loop
		if( i<j && Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))){
			return false;
		}
	}
	return true;
}
