Note: n can be negative integers, need to consider the callstack overflow problem when doing recursion.


class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        
        // Corner case
        if(n == Integer.MIN_VALUE){
            if(x == 1 || x== -1) return 1;
            return 0; 
        }
        return (n%2==0)? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }
}
