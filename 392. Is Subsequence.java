https://leetcode.com/problems/is-subsequence/submissions/

// Level: Easy
// Keywords: 2 pointer, amazon fresh promotion

Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

class Solution {
    public boolean isSubsequence(String s, String t) {
        // Error Check
        if(t==null) { return false; }
        if(s.length() == 0) { return true; }
        
        // Two pointers
        int i = 0;
        int j = 0;
        
        while(j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                // Increment only when matched
                // ie: current chartacter in s found in t
                i++;
                
                // When to return true?
                if(i == s.length()) { return true; }
            }
            j++;
        }
        return false; 
    }
}
