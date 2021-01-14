// Math problem. Involves Integer overflow checking
// To check overflow for x = a*10 +b: If overflow, x/10 != a OR (x-b)/10 != a.

	
	public int reverse(int x) {
	        int a = Math.abs(x);
	        int sign = x>0? 1: -1;
	        
	        int ans = 0;
	        
	        while(a!= 0){
	                // Extraction
	                int tail = a % 10; 
	                
	                // Construction (need a new variable to check overflow by comparing with pre ans)
	                int newAns = ans*10 + tail; 
	                
	                // Check overflow
	                if((newAns-tail) /10 != ans) return 0;
	                // Modification
	                ans = newAns;
	                a = a/10; 
	        }
	        return sign * ans;
	}
