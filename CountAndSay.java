package countAndSay;

public class CountAndSay {
	public String countAndSay(int n) {
		if(n == 1){
			return "1";
		}
		String result = "";
		String tmp = countAndSay(n-1);
		return say(tmp);
    }
	
	public String say(String tmp){
		String result = "";
		char point = tmp.charAt(0);
		int count = 1;
		if(tmp.length() == 1){
			return "11";
		}
		for(int i = 1; i < tmp.length(); i++){
			if(tmp.charAt(i) == point){
				count++;
			}
			else{
				result = result + Integer.toString(count) + point;
				point = tmp.charAt(i);
				count = 1;	
			}
		}
		result = result + Integer.toString(count) + point;
		return result;
	}
	
	public static void main(String[] args){
		CountAndSay t = new CountAndSay();
		System.out.println(t.countAndSay(5));
		System.out.println(t.say("21"));
	}
}
