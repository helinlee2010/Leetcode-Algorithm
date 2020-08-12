https://leetcode.com/problems/sort-an-array/

/** Quick Sort **/

// Time Complexity: worst case: O(n^2) / best case(average): O(nlogn)


class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    };
    
    private void quickSort(int[] arr, int left, int right){       
        if(left< right){
            // Get the final position(index) of first pivot
            int pivotFinalIndex = partition(arr, left, right);
            
            // Recursion
            /* Do the same partitionning work on the left half
               (section less than the pivot) */
            quickSort(arr, left, pivotFinalIndex-1);
            // Do the same for right half
            quickSort(arr, pivotFinalIndex+1, right);
        }
    }
    
    private int partition(int[] arr,int left,int right){
        // Choose a random pivot
        int pivot = arr[right];
        // Two pointers: i, j
        // i: stands at the tail of section of items less than pivot
        int i = left-1;
        // j: move forward, scanning for comparison
        
        for(int j=left; j<right; j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr, i, j);
            }
        }
        // when comparison work done, swap arr[i+1] with the pivot
        swap(arr, i+1, right);
        
        // Return the final position of pivot in this array
        return i+1;
    }
    
    private void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
