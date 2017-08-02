package validSudoku;

public class ValidSudoku {
	
	public boolean isValidSudoku(char[][] board){
		for(int i = 0; i < 9; i++){
			if(!row(board,i)){
				return false;
			}
			//忘记了要是返回false直接失败了
		}
		for(int i = 0; i < 9; i++){
			if(!line(board,i)){
				return false;
			}
		}
		for(int i = 0; i < 9; i++){
			if(!square(board,i)){
				return false;
			}
		}
		
		return true;
	}
	
	public boolean row(char[][] board, int row){
		int[] judge = new int[10];
		for(int i = 0; i < 9; i++){
			if(board[row][i] == '.'){
				continue;
			}
			int a = (int)board[row][i]-48 ;
			if(judge[a] != 0){
				return false;
			}
			judge[a] = 1;
		}
		return true;
	}
	
	public boolean line(char[][] board, int line){
		int[] judge = new int[10];
		for(int i = 0; i < 9; i++){
			if(board[i][line] == '.'){
				continue;
			}
			int a = (int)board[i][line]-48 ;
			if(judge[a] != 0){
				return false;
			}
			judge[a] = 1;
		}
		return true;
	}
	
	public boolean square(char[][] board, int num){
		int row = num/3;
		int line = num%3;
		int begin_row = 3*row;
		int begin_line = 3*line;
		for(int i = 0; i < 3; i++){
			int camparedNextRow = (i+1)%3;
			for(int m = 0; m < 3; m++){
				for(int j = (m+1)%3, k = 0; k < 2; j = (j+1)%3, k++){ //compare to next line
					// int j = (i+1)%3
					if(board[begin_row + camparedNextRow][begin_line + j] == '.' || board[begin_row+i][begin_line+m] == '.'){
						continue;
					}
					if(board[begin_row + camparedNextRow][begin_line + j] == board[begin_row+i][begin_line+m]){
						return false;
					}
				}
			}
			
		}
		
		return true;
	}
	
	public static void main(String[] args){
		char[][] board = new char[][]{{'.','.','4','.','.','.','6','3','.'},
										{'.','.','.','.','.','.','.','.','.'},
										{'5','.','.','.','.','.','.','9','.'},
										{'.','.','.','5','6','.','.','.','.'},
										{'4','3','.','.','.','.','.','.','1'},
										{'.','.','.','7','.','.','.','.','.'},
										{'.','.','.','5','.','.','.','.','.'},
										{'.','.','.','.','.','.','.','.','.'},
										{'.','.','.','.','.','.','.','.','.'}};
		ValidSudoku t = new ValidSudoku();
		System.out.println(t.isValidSudoku(board));
	}
}
