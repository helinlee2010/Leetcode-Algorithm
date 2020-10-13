public boolean searchMatrix(int[][] matrix, int target) {
	// Corner case checking
	if(matrix.length == 0 || matrix[0].length == 0 ) return false;
	
	int targetRow = -1;
	if(matrix.length == 1){
		targetRow = 0;
	}
	
	int row = matrix.length;
	int col = matrix[0].length;
	
	int lo = 0;
	int hi = row-1;
	
	while(lo <= hi){
		int mid = lo + (hi-lo)/2;
		if(matrix[mid][0] == target || matrix[mid][col-1] == target){
			return true;
		}else if(target > matrix[mid][0] && target < matrix[mid][col-1]){
			targetRow = mid;
			break;
		}
		else if(target < matrix[mid][0]){
			hi = mid -1;
		}else{
			lo = mid +1;
		}
	}
	if(targetRow == -1) return false;
	
	// Simple Binary Search within the target row
	int l = 0;
	int r = col -1;
	while(l <= r){
		int center = l + (r-l)/2;
		if(matrix[targetRow][center] == target){
			return true;
		}else if (target < matrix[targetRow][center]){
			r = center - 1;
		}else{
			l = center + 1;
		}
	}
	return false;
}
