Medium
Given an input string, reverse the string word by word.

Example 1:
Input: "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: "  hello world!  "
Output: "world! hello"
(Your reversed string should not contain leading or trailing spaces)

Example 3:
Input: "a good   example"
Output: "example good a"
(You need to reduce multiple spaces between two words to a single space in the reversed string)
 

Note:
A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces. You need to reduce multiple spaces between two words to a single space in the reversed string.

public class Solution {

    public static void main(String[] args) throws Exception {
	    String input = "  hello world!  ";
	    String output = reverseWordsInString(input);
	    System.out.println(output);
    }

    private static String reverseWordsInString1(String str) {
        String [] wordArr = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=wordArr.length-1; i>=0; i--){
            sb.append(wordArr[i]).append(" ");
        }
        return sb.toString().trim();
    }
    
    private static String reverseWordsInString2(String str) {
        if(s.isEmpty()) return "";
        
        String[] strArr = str.split("\\s+");
        
        int i = 0, j = strArr.length - 1; 
        while(i < j){
            String temp = strArr[i];
            strArr[i++] = strArr[j];
            strArr[j--] = temp;
        }
        
        StringBuilder sb = new StringBuilder();
       
        for(String str : strArr){
            sb.append(str).append(" ");
        }
        return sb.toString().trim();
    }
}
