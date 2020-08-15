88. Merge Sorted Array (Easy)

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1 tail's index
        int i = m-1;
        // nums2 tail's index
        int j = n-1;
        // nums1 last slot
        int k = nums1.length -1;

        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[k] = nums1[i];
                i--;
                k--;
            }else{
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
        // Short Version:
        // while (tail1 >= 0 && tail2 >= 0) {
        //     nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? 
        //                          nums1[tail1--] : nums2[tail2--];
        // }
        
        
        //nums1 out of bound, simply adding all remaining numbers in nums2
        //because theses arrays are sorted
        while(i<0 && j>=0){
            nums1[k--] = nums2[j--];
        }
    }
}

// Version 2 (w/ For loop, decrement)

public void merge(int[] nums1, int m, int[] nums2, int n) {
	 
		int nums1Tail = m - 1;
    int nums2Tail = n - 1;
    
		for (int i = m + n - 1; i >= 0; i--) {
			if (nums2Tail == -1) {
				break;
			} else if (nums1Tail == -1 || nums2[nums2Tail] >= nums1[nums1Tail]) {
				nums1[i] = nums2[nums2Tail--];
			} else {
				nums1[i] = nums1[nums1Tail--];
			}
		}
}
