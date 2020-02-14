(Level: Easy)
Implement int sqrt(int x).
Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:
Input: 81 
Output: 9

Example 2:
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842...,and since the decimal part is truncated, 2 is returned.

public class Solution {

    public static void main(String[] args){
	    int givenNum = 8;
	    int result = mySqrt(givenNum);
	    System.out.println(result);
    }

    public static int mySqrt(int x) {
        //Special case
        if (x == 0) {
            return 0;
        }
        //indicate left most point and right most point
        int left = 1;
        int right = x;
        //int mid = left + (right - left) / 2;

        //to prevent negative integer input
        while (left <= right) {
            //this mid should be inside the loop, important!!!
            int mid = left + (right - left) / 2;
            //if mid square is x
            if (mid == x / mid) {
                return mid;
            }
            //else if mid square is greater than x
            //that means the answer is located in between 1 & mid
            else if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}
