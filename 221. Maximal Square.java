Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

// Dynamic Programming Approach
// Time&Space: O(M*N)

public int maximalSquare(char[][] matrix) {
	// Corner case;
	if(matrix.length == 0) return 0;

	int row = matrix.length;
	int col = matrix[0].length;

	int maxWidth = 0;

	int[][] dp = new int[row][col];

	for(int r=0; r<row; r++){
		for(int c=0; c<col; c++){
			if(matrix[r][c]=='1'){
				if(r==0 || c==0){
					dp[r][c] = 1;
				}else{
					dp[r][c] = Math.min(dp[r][c-1], Math.min(dp[r-1][c],dp[r-1][c-1])) + 1;
				}
				maxWidth = Math.max(maxWidth, dp[r][c]);
			}
		}
	}
	return maxWidth*maxWidth;
}
