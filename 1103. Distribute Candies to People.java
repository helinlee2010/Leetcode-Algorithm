https://leetcode.com/problems/distribute-candies-to-people/
// Level: Easy
We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.
Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.
This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).
Return an array (of length num_people and sum candies) that represents the final distribution of candies.
Example:
Input: candies = 10, num_people = 3
Output: [5,2,3]
 
// O(N)
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int remaining = candies;
        int i = 0;
        int[] result = new int[num_people];
        
        while(remaining >0){
            int distribute = i+1;
            if(remaining >= distribute){
                result[i % num_people] += distribute;
            }else{
                result[i % num_people] += remaining;
                break;
            }
            
            remaining = remaining - distribute;
            i++;
        }
        return result;
    }
}
