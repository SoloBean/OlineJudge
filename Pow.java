package pow;

public class Pow {
	public double myPow(double x, int n){
		double result = 1;
		if(n == 0) {
			return 1;
		}
		if(n < 0){
			return 1/myPow(x, -1*n);
		}
		double b = x*x;
		int round = n/2;
		for(int i = 0; i < round; i++){
			result *= b;
		}
		if(n%2 == 1){
			result *= x;
		}
		return result;
	}
	
	public double myPow2(double x, int n) {
		if (x == 1.0 || x == 0.0 || x == -1.0) {
            return n % 2 != 0 ? x : x * x;
        }
        if (n < 0) {
             return 1 / power(x, -n);
        } else {
             return power(x, n);
        }
    }
	public double power(double x, int n) {
        if (n == 0)
            return 1;
 
        double v = power(x, n / 2);
 
        if ((n & 1) == 0) {
            return v * v;
        } else {
           return v * v * x;
       }
	}
	
	public double myPow3(double x, int n) {
        if (n == 0) return 1;
        
        long m = (long) n;
        if (n < 0) {
            x = 1 / x;
            m = -m;
        }
        
        double ans = 1;
        while (m > 0) {
            if ((m & 1) == 1) ans *= x;
            x = x * x;
            m = m / 2;
        }
        
        return ans;
    }
	
	public static void main(String[] args){
		Pow t = new Pow();
		Long start = System.currentTimeMillis();
		double result = t.myPow(0.00001, 2147483647);
		Long end = System.currentTimeMillis();
		System.out.println((end-start));
		System.out.println(result);
		
	}
}
