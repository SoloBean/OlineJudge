package plusOne;

public class PlusOne {
	public int[] plusOne(int[] digits){
		int i = digits.length-1;
		boolean flag = true;
		for(; i >= 0; i--){
			if(digits[i] == 9 && flag){
				digits[i] = 0;
				continue;
			}
			else{
				flag = false;
				digits[i] += 1;
				break;
			}
		}
		if(i == -1){
			int[] res = new int[digits.length+1];
			res[0] = 1;
			for(int j = 1; j < digits.length+1; j++){
				res[j] = digits[j-1];
			}
			return res;
		}
		else{
			return digits;
		}
	}
	
	public static void main(String[] args){
		int[] digits = new int[]{9,9,9,8,9};
		PlusOne t = new PlusOne();
		int[] res = t.plusOne(digits);
		for(int i = 0; i < res.length; i++){
			System.out.print(res[i]);
			
		}
	}
}
