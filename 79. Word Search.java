Given a 2D board and a word, find if the word exists in the grid.The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
  
  
public boolean exist(char[][] board, String word) {
	char firstChar = word.charAt(0);
	for(int i=0; i<board.length; i++){
		for(int j=0; j<board[0].length; j++){
			if(dfs(i,j, board, word, 0)){
				return true;
			}
		}
	}
	return false;
}
	
private boolean dfs(int i, int j, char[][] board, String word, int idx){
	if(idx == word.length()) return true; 

	if(i<0 || i>= board.length || j<0 || j>= board[0].length || board[i][j] != word.charAt(idx)) return false;

	char temp = board [i][j];
	board[i][j] = '*';

	// Left, Down, Right, Up
	boolean found = dfs(i, j-1, board, word, idx+1) 
		|| dfs(i+1, j, board, word, idx+1)
		|| dfs(i, j+1, board, word, idx+1) 
		|| dfs(i-1, j, board, word, idx+1);

	board[i][j] = temp;         // Important !
	return found;
}
