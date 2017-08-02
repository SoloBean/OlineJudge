package spiralMatrix2;

public class GenerateMatrix {
	public int[][] generateMatrix(int n){
		int[][] res = new int[n][n];
		if(n == 0){
			return res;
		}
		if(n == 1){
			int[][] t = {{1}};
			return t;
		}
		int sum = 1;
		for(int i = 0; i < (n+1)/2; i++){
			int count = n - 2*i - 1;
			int x = i, y = i;
			if(count == 0){
				res[i][i] = sum;
			}
			else{
				for(int j = 0; j < count; j++){
					res[x][y] = sum;
					sum++;
					y++;
				}
				for(int j = 0; j < count; j++){
					res[x][y] = sum;
					sum++;
					x++;
				}
				for(int j = 0; j < count; j++){
					res[x][y] = sum;
					sum++;
					y--;
				}
				for(int j = 0; j < count; j++){
					res[x][y] = sum;
					sum++;
					x--;
				}
			}
		}
		
		return res;
	}
	public static void main(String[] args){
		GenerateMatrix t = new GenerateMatrix();
		int[][] res = t.generateMatrix(3);
		int length = res.length;
		for(int i = 0; i < length; i++){
			for(int j = 0; j < length; j++){
				System.out.print(res[i][j]+",");
			}
			System.out.println();
		}
	}
}
