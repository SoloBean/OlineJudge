package spiralMatrix;

import java.util.List;
import java.util.ArrayList;

public class SpiralOrder {
	public List<Integer> spiralOrder(int[][] matrix){
		List<Integer> result =  new ArrayList<>();
		if(matrix.length == 0){
			return result;
		}
		int start = 0;int depth = matrix.length-1; int end = matrix[0].length-1;
		result = wapper(start, end, depth, matrix);
		return result;
	}
	
	public List<Integer> wapper(int start, int end, int depth, int[][] matrix){
		List<Integer> result = new ArrayList<>();
		if(depth < start || end < start){
			return null;
		}
		if(depth == start){
			for(int i = start; i <= end; i++){
				result.add(matrix[start][i]);
			}
		}
		else if(end == start){
			for(int i = start; i <= depth; i++){
				result.add(matrix[i][start]);
			}
		}
		else{
			List<Integer> list = wapper(start+1, end-1, depth-1, matrix);
			int i = start, j = start;
			for(; j < end; j++){
				result.add(matrix[i][j]);
			}
			for(; i < depth; i++){
				result.add(matrix[i][j]);
			}
			for(; j > start; j--){
				result.add(matrix[i][j]);
			}
			for(; i > start; i--){
				result.add(matrix[i][j]);
			}
			if(list != null){
				for(int k = 0; k < list.size(); k++){
					result.add(list.get(k));
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args){
//		int[][] matrix = new int[][]{{1,2,3},
//									 {4,5,6},
//									 {7,8,9}};
		int[][] matrix = {{}};
//		int m = matrix.length;
//		int n = matrix[0].length;
//		System.out.println("m="+m+" n="+n);
		SpiralOrder t = new SpiralOrder();
		List<Integer> result = t.spiralOrder(matrix);
		if(result == null){
			System.out.println("x");
		}
		else{
			for(int i = 0; i < result.size(); i++){
				System.out.print(result.get(i)+",");
			}
		}
	}
}
