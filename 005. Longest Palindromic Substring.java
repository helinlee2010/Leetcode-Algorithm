https://leetcode.com/problems/longest-palindromic-substring/

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"

class Solution {
    int start;
    int maxLen=0;
    
    public String longestPalindrome(String s) {
        // Boundary Check
        if (s == null || s.length()<= 1){
            return s;
        }      
        
        // Check if each character is a possible center of panlindromic substring
        for(int i=0; i<s.length(); i++){
            // Assume the palindrome has an odd length
            expandFromCenter(s, i, i);
            // Assume the palindrome has an even length
            expandFromCenter(s, i, i+1);
        }      
        return s.substring(start, start+maxLen);
    }
    
    public void expandFromCenter(String s, int left, int right){
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        if ( maxLen < right - left -1){
            // Plus 1 because the left point has decremented before jumping out of the while loop, add 1 back
            start = left + 1;
            // update maxLen
            maxLen = (right-1) - (left +1) +1;
        }    
    }
}

Time Complexity: O(N^2)
