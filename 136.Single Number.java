// HashMap Slower

public int singleNumber(int[] nums) {
	// The num can be a negative int
	int len = nums.length;
	if(len ==1) return nums[0];
	
	Map<Integer, Integer> map = new HashMap<>();
	
	for(int i=0; i<len; i++){
		map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
	}
	
	for(Map.Entry<Integer, Integer> e: map.entrySet()){
		if(e.getValue()==1) return e.getKey(); 
	}
	return -1;
}

// XOR fast less space

public int singleNumber(int[] nums) {
	int ans = 0;
	int len = nums.length;
	
	for(int i = 0; i<len; i++){
		ans ^= nums[i];
	}
	return ans;
}
