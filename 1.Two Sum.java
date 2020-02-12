Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].

import java.util.HashMap;
import java.util.Map;

//Using hash map to solve
//reference (hashmap methods): .containsKey()   &  .getOrDefault()  &  .put()
public class Solution {
    public static void main(String[] args) throws Exception {
	    int [] input = new int[] {1,7,11,15};
	    int target= 9;
	    int[] result = twoSum(input, target);
	    System.out.println("[" + result[0] +"," +result[1] + "]");
    }

    public static int[] twoSum(int[] arr, int target) throws Exception {
        //Create a hash map indicates the visited numbers and their indices
        Map<Integer, Integer> visitedNum = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            int delta = target - arr[i]; //the difference between target number and current visiting number
            if(visitedNum.containsKey(delta)){
                return new int[] {i, visitedNum.getOrDefault(delta, -1)};
            }
            visitedNum.put(arr[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
