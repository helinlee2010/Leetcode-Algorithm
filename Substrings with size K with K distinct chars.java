Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.
Example 1:
Input: s = "abcabc", k = 3
Output: ["abc", "bca", "cab"]
Example 2:
Input: s = "abacab", k = 3
Output: ["bac", "cab"]

Constraints: 
• The input string consists of only lowercase English letters [a-z] & 0 ≤ k ≤ 26

Time: O(N)? Space: O(N)


public class Main {
    
    public static List<String> uniqueSubstringSizeK(String s, int k) {
        Set<String> substringSet = new HashSet<>();
        int[] freq = new int[26];
       
        int start = 0;
        int end = 0;
        while( end< s.length() ){
            // 只要窗口里有重复字母 缩进窗口开头 先更新字母频率 再move
            while(freq[s.charAt(end)-'a']!=0){
                freq[s.charAt(start)-'a']--;
                start++;
            } 
            // 更新窗口end字母的频率
            freq[s.charAt(end)-'a']++;
            // 若窗口size符合标准 加入到result里 更新窗口开头再move on
            if(end - start == k-1){
                substringSet.add(s.substring(start, end+1));
                freq[s.charAt(start)-'a']--;
                start++;
            }
            // 别忘记这个
            end ++;
        }
        
        return new ArrayList<String>(substringSet);
    }
    
    public static void main(String[] args) {
        List<String> result1 = uniqueSubstringSizeK("abcabc", 3);
        List<String> result2 = uniqueSubstringSizeK("abacab", 3);
        List<String> result3 = uniqueSubstringSizeK("awaglknagawunagwkwagl", 4);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
