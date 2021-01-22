Given a sorted array of distinct integers and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
// Array is Sorted!! 
// Earliest found index

Example:
Input: nums = [1,3,5,6], target = 2
Output: 1

public int searchInsert(int[] nums, int target) {
	// Edge case
	int len = nums.length;
	if(len == 1){
		if(nums[0] == target || target < nums[0]){
			return 0;
		}else{
			return 1;
		}
	} 
	
	// Since sorted array, special cases
	if(target <= nums[0]) return 0;
	if(target > nums[len-1]) return len;
	
	// Other cases
	for(int i=0; i<len-1; i++){
		if(nums[i] == target){
			return i;
		}else if(target > nums[i] && target <= nums[i+1]){
			return i+1;
		}
	}
	// Dummy, won't reach here
	return -1;
}





