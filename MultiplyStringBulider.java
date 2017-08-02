package multiplyStrings;

public class MultiplyStringBulider {
	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")){
			return "0";
		}
		String result = "0";
        if(num1.length() < num2.length()){
        	String tmp = null;
        	tmp = num1;
        	num1 = num2;
        	num2 = tmp;
        }
        for(int i = num2.length()-1; i >= 0; i--){
        	char rate = num2.charAt(i);
        	String tmp = multiply(num1, rate, num2.length()-1-i);
        	result = add(tmp, result);
        }
		result = rotate(result);
		return result;
    }
	
	public String multiply(String multi, char rate, int round){
		StringBuilder result = new StringBuilder();
		int a = (int)rate - 48;
		int front = 0;
		for(int i = 0; i < round; i++){
			result.append("0");
		}
		for(int i = multi.length()-1; i >= 0; i--){
			char mul = multi.charAt(i);
			int b = (int)mul - 48;
			int middleResult = a*b + front;
			int middleString = middleResult%10;
			front = middleResult/10;
			result.append(String.valueOf(middleString));
		}
		if(front != 0){
			result.append(String.valueOf(front));
		}
		return result.toString();
	}
	
	public String add(String add1, String add2){
		//�ַ��Ƿ�������
		if(add2.equals("0")){
			return add1;
		}
		if(add1.equals("0")){
			return add2;
		}
		StringBuilder result = new StringBuilder();
		//the length of add1 >= add2
		int front = 0;
		for(int i = 0; i < add2.length(); i++){
			int a = (int)add2.charAt(i)-48;
			int b = (int)add1.charAt(i)-48;
			int sum = a+b+front;
			if(sum >= 10){
				front = 1;
				sum = sum - 10;
			}
			else{
				front = 0;
			}
			result.append(String.valueOf(sum));
		}
		if(front == 1){
			if(add1.length() - add2.length() == 0){
				result.append("1");
			}
			else {
				String tmp = add1.substring(add2.length(), add1.length());
				String tmpResult = add(tmp, "1");
				result.append(tmpResult);
			}
		}
		else{
			result.append(add1.substring(add2.length(), add1.length()));
		}
		
		return result.toString();
	}
	
	public String rotate(String cur){
		StringBuilder result = new StringBuilder(cur);
		return result.reverse().toString();
	}
	
	public static void main(String[] args){
		MultiplyStrings t = new MultiplyStrings();
		String a = "4806";
		String b = "896";
		String result = t.multiply(a, b);
		System.out.println(result);
	}
}
