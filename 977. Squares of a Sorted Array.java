https://leetcode.com/problems/squares-of-a-sorted-array/
//Level: Easy
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

Example Input: [-4,-1,0,3,10]
Example Output: [0,1,9,16,100] 

//O(N)Approach 2pointers

public int[] sortedSquares(int[] A) {
    int len = A.length;
    int[] result = new int[len];
    int nonNegPointer = 0;
    
    while(nonNegPointer < len && A[nonNegPointer]<0){
        nonNegPointer++;
    }
    
    int negPointer = nonNegPointer -1;
    int i = 0;
    while(negPointer >= 0 && nonNegPointer < len && i<len){
        // int negSquare = (int)Math.pow(A[negPointer],2);
        int negSquare = A[negPointer]*A[negPointer];
        int posSquare = A[nonNegPointer]*A[nonNegPointer];
        if(negSquare <= posSquare){
            result[i] = negSquare;
            negPointer --;
        }else{
            result[i] = posSquare;
            nonNegPointer ++;
        }
        i++;
    }
    
    // Catch the remaining part if one side reaches its end
    while(negPointer >= 0){
        result[i] = A[negPointer]*A[negPointer];
        negPointer--;
        i++;
    }
    while(nonNegPointer < len) {
        result[i] = A[nonNegPointer]*A[nonNegPointer];
        nonNegPointer++;
        i++;
    }
    
    return result;
}


// Brute-force, O(nlogn) approach
public int[] sortedSquares(int[] A) {
	int len = A.length;
	int[] result = new int[len];
	for(int i=0; i<len; i++){
		result[i] = (int) Math.pow(A[i],2);
	}
	
	Arrays.sort(result);
	return result;
}
