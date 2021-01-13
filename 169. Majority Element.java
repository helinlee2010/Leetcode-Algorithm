// Code version 1
public int majorityElement(int[] nums) {
	
	Map<Integer, Integer> map = new HashMap<>();
	
	for(int num: nums){
		int count = map.getOrDefault(num, 0);
		map.put(num, count+1);
	}
	
	
	for(int num: nums){
		if( map.get(num)> nums.length/2 ) return num;
	}
	
	return -1;
}

// Code version 2 (Faster)
public int majorityElement(int[] nums) {
	if(nums==null || nums.length ==0) return -1;
	
	int len = nums.length;
	if(nums.length <= 2) return nums[0];
	
	Arrays.sort(nums);
	
	return nums[len/2];
}
