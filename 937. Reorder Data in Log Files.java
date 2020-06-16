https://leetcode.com/problems/reorder-data-in-log-files/
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
Return the final order of the logs.

 

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 

Constraints:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.



class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<>(){
            @Override
            public int compare(String s1, String s2) {
                String[] split1 = s1.split(" ", 2);
                String[] split2 = s2.split(" ", 2);

                // split[0] is identifier, split1[1] is content.
                // First character of the content: split1[1].charAt(0);

                // Convert String to Character & use isDigit() Character method
                // Because charAt returns a String

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if(!isDigit1 && !isDigit2){
                    int precomp = split1[1].compareTo(split2[1]);
                    if (precomp == 0){
                        return split1[0].compareTo(split2[0]);
                    }else{
                        return precomp;
                    }
                }else if(isDigit1 && isDigit2){
                    // doese this keep original order?
                    return 0;
                }else if(isDigit1 && !isDigit2){
                    return 1;
                }else{
                    // s1 is letter, s2 is digit
                    return -1;
                }
            }
        };
        // Sort the original String[] logs with customized comparator
        Arrays.sort(logs, myComp);
        return logs;
    }
}

Runtime: 5 ms, Memory Usage: 40 MB, 63 / 63 test cases passed.
