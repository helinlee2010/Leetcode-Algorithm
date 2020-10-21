You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]


public void rotate(int[][] matrix) {
	int n = matrix.length;
	// 1. Transpose
	for(int i = 0; i<n; i++){
		for(int j=i; j<n; j++){
			swap(matrix, i, j);
		}
	}
	
	// 2. Flip
	for(int i=0; i<n; i++){
		for(int j=0; j<n/2; j++){
			int temp = matrix[i][j];
			matrix[i][j] = matrix[i][n-1-j];
			matrix[i][n-1-j] = temp;
		}
	}
}

private void swap(int[][]matrix, int i, int j){
	int temp = matrix[i][j];
	matrix[i][j] = matrix[j][i];
	matrix[j][i] = temp;
}
