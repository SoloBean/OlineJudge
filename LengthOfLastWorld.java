package lengthOfLastWorld;

public class LengthOfLastWorld {
	public int lengthOfLastWorld(String s){
		if(s.equals("")){
			return 0;
		}
		String[] tmp = s.split(" ");
		if(tmp.length == 0){
			return 0;
		}
		
		return tmp[tmp.length-1].length();
	}
	
	public static void main(String[] args){
		String s = "    s    t ";
		String t = s.trim();
		System.out.println(t);
		String[] tmp = s.split(" ");
		System.out.println(tmp.length);
		for(int i = 0; i < tmp.length; i++){
			System.out.println(tmp[i]+","+i);
		}
	}
}
