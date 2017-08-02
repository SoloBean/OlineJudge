package uniquePaths;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		m = m-1;
		n = n-1;
		if( m == 0 || n == 0){
        	return 1;
        }
        if(m > n){
        	int t = n;
        	n = m; 
        	m = t;
        }
        long middleRes = 1;
        for(int i = m+n; i > n; i--){
        	middleRes *= i;
        }
        long res = middleRes/cal(m);
        return (int)res;
    }
	
	public int cal(int m){
		if(m == 1){
			return 1;
		}
		else{
			return m*cal(m-1);
		}
	}
	
	public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if((m-1) == 0 || (n-1) == 0){
        	if((m-1) == 0 && (n-1) == 0){
        		return grid[0][0];
        	}
        	else if((m-1) == 0){
        		int sum = 0;
        		for(int i = 0; i < n; i++){
        			sum += grid[0][i];
        		}
        		return sum;
        	}
        	else {
        		int sum = 0;
        		for(int i = 0; i < m; i++){
        			sum += grid[i][0];
        		}
        		return sum;
        	}
        }
        
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        
        for(int i = 1; i < n ; i++){
        	res[0][i] = grid[0][i] + res[0][i-1];
        }
        for(int i = 1; i < m ; i++){
        	res[i][0] = grid[i][0] + res[i-1][0];
        }
        
        for(int i = 1; i < m ; i++){
        	for(int j = 1; j < n ; j++){
        		if(res[i-1][j] < res[i][j-1]){
        			res[i][j] = res[i-1][j] + grid[i][j];
        		}
        		else{
        			res[i][j] = res[i][j-1] + grid[i][j];
        		}
        	}
        }
        
        return res[m-1][n-1];
    }
	
	public static void main(String[] args){
		UniquePaths t = new UniquePaths();
		int[][] grid = new int[][]{{9,1,4,8}};
		int res = t.minPathSum(grid);
		System.out.println(res);
		
	}
}
