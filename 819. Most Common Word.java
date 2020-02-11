Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.


Example:

Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"

Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
  
Reference/ Hint:
1.split("seperator")
2.toLowerCase()
3.To separate a String based on non-word characters: use "\\W+".
4. The getOrDefault(Object key, V defaultValue) method of Map interface, implemented by HashMap class.
  Used to get the value mapped with specified key. (If no value is mapped with the provided key then the default value is returned).
5. The java.util.HashMap.keySet() method is used to create a set out of the key elements contained in the hash map. It basically returns a Set of the keys or we can create a new set and store the key elements in them. hash_map.keySet()
6. 	Map method: get(Object key)
Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.

  


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static String mostCommonWord(String input, String[] banned){
        //convert input paragraph into String Array consist of each single word
        String[] inputInArray = input.toLowerCase().split("\\W+");
        
        //Create a set of banned words
        Set<String> bannedSet = new HashSet<>();
        for(String word : banned){
            bannedSet.add(word);
        }

        //Create a HashMap<Word,Frequency>
        Map<String, Integer> map = new HashMap<>();
        for(String str :inputInArray){
            if(!bannedSet.contains(str)) {
                map.put(str, (map.getOrDefault(str, 0)) + 1);
            }
        }

        //Check the max frequency and update the result
        int maxFreq = 0;
        String result = "";
        for (String word : map.keySet()){
            if(map.get(word)>maxFreq){
                maxFreq = map.get(word);
                result = word;
            }
        }
        return result;
    }

    public static void main(String[] args) {
	    String input = "Bob hit a ball, the hit BALL flew far after it was hit.";
	    String[] banned = {"hit"};
	    System.out.println(mostCommonWord(input, banned));
    }
}
