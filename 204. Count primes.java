https://leetcode.com/problems/count-primes/
//Level: Easy    (Sieve of Eratosthenes)
// Count how many prime numbers less than n (n>=0)
//Time：O(N log logN)  Space: O(N)
Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        for(int i=0; i<primes.length; i++){
            primes[i] = true; 
        }
        
        // Loop through each number, mark any two nums' product as non-prime
        // First prime num is 2, so start with 2
        for(int i=2; i*i<n; i++){
            // 如果它不是质数 它product已经被mark过了
            // 比如4的任何乘积 也是2的乘积
            if(primes[i]){
                for(int j=i; i*j<n; j++){
                    primes[i*j] = false;
                }
            }
        }
        int primesCount = 0;
        //同样的 从2开始算起
        for(int i=2; i<primes.length; i++){
            if(primes[i]) primesCount ++;
        }
        return primesCount;
    }
}
