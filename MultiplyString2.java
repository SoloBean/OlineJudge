package multiplyStrings;

public class MultiplyString2 {
	public String multiply(String num1, String num2) {
	    StringBuilder sb = new StringBuilder();
	    int m = num1.length(), n = num2.length(), carry = 0;
	    
	    if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
	    
	    for (int k = 0; k < m+n-1; k++) {
	        for (int i = Math.max(0,k-n+1); i < Math.min(m,k+1); i++) {
	            int j = k-i;
	            carry += (num1.charAt(m-i-1)-'0')*(num2.charAt(n-j-1)-'0');
	        }
	        sb.append(carry%10);
	        carry = carry/10;
	    }
	    if (carry > 0) sb.append(carry);
	    return sb.reverse().toString();
	}
}
