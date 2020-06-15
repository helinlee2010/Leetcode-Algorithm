https://aonecode.com/amazon-online-assessment-zombie-matrix
	
  Given a 2D grid, each cell is either a zombie or a human. Zombies can turn adjacent (up/down/left/right) human beings into zombies every day. Find out how many days does it take to infect all humans?
	• Input:
	matrix, a 2D integer array where a[i][j] = 1 represents a zombie on the cell and a[i][j] = 0 represents a human on the cell.
	• Output:
	Return an integer represent how many days does it take to infect all humans.
  Return -1 if no zombie exists.


import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int humanDays(int[][] matrix) {
		// Boundary Check
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
		    return -1;
		}
		
		// Directions
		int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		Queue<int[]> queue = new LinkedList<>();
		
		int humanCount = 0;
		
		for(int i=0; i<rows; i++){
		    for (int j=0; j<cols; j++){
		        // Add any zombie's coordinate to the queue
		        if (matrix[i][j]==1){
		            queue.offer(new int[] {i,j});
		        }else {
		            humanCount++;
		        }
		    }
		}
		
		int day = 0;
		while (!queue.isEmpty()){
		   int size = queue.size();
		   for(int i=0; i<size; i++){
		       int[] curr = queue.poll();
		       for (int[] dir: dirs){
		           int neiX = curr[0] + dir[0];
		           int neiY = curr[1] + dir[1];
		           if (inBound(matrix, neiX, neiY) && matrix[neiX][neiY] == 0){
    		           matrix[neiX][neiY] = 1;
    		           queue.offer(new int[]{neiX, neiY});
    		           humanCount--;
		           }
		       }
		       
		       
		   }
		   if (!queue.isEmpty()){
		       day++;
		   }
		}
		return humanCount == 0? day : -1;
	}
	
	public boolean inBound(int[][] matrix, int x, int y){
	    return (x>=0 && x< matrix.length && y>=0 && y < matrix[0].length);
	}
}

Testcase -- (69/87) Time Limit Exceed
