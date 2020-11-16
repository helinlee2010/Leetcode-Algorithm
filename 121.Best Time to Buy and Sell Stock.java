Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
             
//Brute Force:
class Solution {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        //If I buy a stock at the last day, I can't sell it
        for(int i=0; i<prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++){
               int profit = prices[j]-prices[i];
                if(profit>maxProfit)
                    maxProfit = profit;
            }
        }
        return maxProfit;
    }
    
    public static void main (String[] args){
        int[] stock = {7,1,5,3,6,4};
        System.out.println(maxProfit(stock));
    }
}

// O(N)
public int maxProfit(int[] prices) {
	// Corner case
	if(prices == null || prices.length<=1) return 0;
	
	int min = prices[0];
	int profit = 0;
	
	for(int i=1; i<prices.length; i++){
		int curr = prices[i];
		
		if(curr > min){
		
			profit = Math.max(profit, curr-min);
			
		}else{ //curr<=min, update the min
		
			min = curr;
		}
	}
	return profit;
}
