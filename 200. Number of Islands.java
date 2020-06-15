https://leetcode.com/problems/number-of-islands/

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example Input:
11000
11000
00100
00011       Example Output: 3

class Solution {
    // Directions
        final int[][] dirs = {{1,0},{-1,0}, {0,1}, {0,-1}};
    
    public int numIslands(char[][] grid) { 
        // Sanity Checks
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        final int rows = grid.length;
        final int cols = grid[0].length;
        
        int count = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if (grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, rows, cols);
                }  
            }
        }
        return count;
    }
    
    // parameters x, y are the coordinate
    public void dfs(char[][]grid, int x, int y, int rows, int cols){
        // Base case
        if (x<0 || y<0 || x >= rows || y>=cols || grid[x][y] != '1') {return;}
        
        grid[x][y] = '2';
        
        // Recursion
        for (int[] dir : dirs){
            int neighborX = dir[0] + x;
            int neighborY = dir[1] + y;
            dfs(grid, neighborX, neighborY, rows, cols);
        }
        
    }
}



