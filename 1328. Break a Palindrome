https://leetcode.com/problems/break-a-palindrome/
// Level: Medium
// Time: O(N)

class Solution {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        StringBuilder sb = new StringBuilder(palindrome); 
        if(len == 1) return "";
        
        // no need to check the very center char
        for(int i=0; i< len/2; i++){
            int j = len-1-i;
            if(palindrome.charAt(i) != 'a'){
                char ch = 'a';
                sb.setCharAt(i, ch);
                return sb.toString();
            }
        }
        //exit for-loop, all 'a' or 'aabaa'
        char ch = 'b';
        sb.setCharAt(len-1, ch);
        return sb.toString();
    }
}
