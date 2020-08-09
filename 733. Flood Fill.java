https://leetcode.com/problems/flood-fill/
Input: 
image = [[1,1,1],
         [1,1,0],
         [1,0,1]]
sr = 1, sc = 1, newColor = 2

Output: [[2,2,2],
         [2,2,0],
         [2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor){
            return image;
        }
        else{
            fill(image, sr, sc, image[sr][sc], newColor);
            return image;
        }
    }
    
    
    // need to keep track of initial color
    public void fill(int[][] image, int i, int j, int initColor, int newColor){
        if(i<0 || j<0 || i>=image.length || j>=image[0].length || image[i][j] != initColor){
            return;
        }
        image[i][j] = newColor;
        // Recursive DFS      
        // Go up
        fill(image, i-1, j, initColor, newColor);
        // Go down
        fill(image, i+1, j, initColor, newColor);
        // Go left
        fill(image, i, j-1, initColor, newColor);
        // Go right
        fill(image, i, j+1, initColor, newColor);
    }
