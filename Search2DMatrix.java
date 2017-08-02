package search2DMatrix;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0){
			return false;
		}
        return back(matrix, target, 0, 0, matrix[0].length-1, matrix.length-1);
    }
	
	public boolean back(int[][] matrix, int target, int beginRow, int beginCol,  int length, int width){
		int column = -1, row = -1;
		if(beginRow > width || beginCol > length){
			return false;
		}
		for(int i = length; i>=0; i--){
			if(matrix[beginRow][i] == target){
				return true;
			}
			else if(matrix[beginRow][i] < target){
				column = i;
				beginRow++;
				break;
			}
		}
		if(column == -1){
			return false;
		}
		for(int i = width; i >= beginCol; i--){
			if(matrix[i][beginCol] == target){
				return true;
			}
			else if(matrix[i][beginCol] < target){
				row = i;
				beginCol++;
				break;
			}
		}
		if(row == -1){
			return false;
		}
		
		return back(matrix, target, beginRow, beginCol, column, row);
	}
	
	public static void main(String[] args){
		int[][] matrix  = new int[][]{
			{1},
			{3},
			{5}};
		Search2DMatrix t = new Search2DMatrix();
		if(t.searchMatrix(matrix, 8)){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
	}
}
