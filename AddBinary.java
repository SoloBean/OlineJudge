package plusOne;

public class AddBinary {
	public String addBinary(String a, String b){
		if(a.length() <  b.length()){
			String t = "";
			t = a;
			a = b;
			b = t;
		}
		StringBuilder res = new StringBuilder();
		char middle = '0';
		int i = b.length()-1, j = a.length()-1;
		for(; i >= 0; i--, j--){
			if(b.charAt(i) == '0' && a.charAt(j) == '0'){
				res.append(middle);
				middle = '0';
			}
			else if(b.charAt(i) == '1' && a.charAt(j) == '1'){
				res.append(middle);
				middle = '1';
			}
			else {
				if(middle == '0'){
					res.append('1');
					middle = '0';
				}
				else{
					res.append('0');
					middle = '1';
				}
			}
		}
		if(middle == '1'){
			if(a.length() == b.length()){
				res.append('1');
				return res.reverse().toString();
			}
			else {
				for(; j >= 0; j-- ){
					if(a.charAt(j) == '0'){
						res.append('1');
						middle = '0';
						j--;
						break;
					}
					res.append('0');
				}
			}
		}
			
		while(j >= 0){
			res.append(a.charAt(j));
			j--;
		}
		if(middle == '1'){
			res.append(middle);
		}
		return res.reverse().toString(); 
	}
	
	public static void main(String[] arg){
		String a = "10";
		String b = "110";
		AddBinary t = new AddBinary();
		String res = t.addBinary(a, b);
		System.out.println(res);
		
	}
}
