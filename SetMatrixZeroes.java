package setMatrixZeroes;

public class  SetMatrixZeroes{
	public void setZeroes(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		
		//first row and first column
		boolean firstRow = false, firstColumn = false;
		if(matrix[0][0] == 0){
			firstRow = true;
			firstColumn = true;
		}
		else {
			for( int i = 1; i < n; i++){
				if(matrix[0][i] == 0){
					firstRow = true;
					break;
				}
			}
			for(int i = 1; i < m; i++){
				if(matrix[i][0] == 0){
					firstColumn = true;
					break;
				}
			}
		}
		
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				if(matrix[i][j] == 0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for(int i = 1; i < m; i++){
			if(matrix[i][0] == 0){
				setRowZero(matrix,i);
			}
		}
		for(int i = 1; i < n; i++){
			if(matrix[0][i] == 0){
				setColumnZero(matrix,i);
			}
		}
		if(firstRow){
			setRowZero(matrix,0);
		}
		if(firstColumn){
			setColumnZero(matrix,0);
		}
	}
	
	public void setColumnZero(int[][] matrix, int column){
		for(int i = 0; i < matrix.length; i++){
			matrix[i][column] = 0;
		}
	}
	
	public void setRowZero(int[][] matrix, int row){
		for(int i = 0; i < matrix[0].length; i++){
			matrix[row][i] = 0;
		}
	}
	
	public static void main(String[] args){
		int[][] matrix = new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		SetMatrixZeroes t = new SetMatrixZeroes();
		t.setZeroes(matrix);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]+",");
			}
			System.out.println();
		}
	}
}
