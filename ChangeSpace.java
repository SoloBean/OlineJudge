package offer;

public class ChangeSpace {
	public static void main(String[] args){
		String t = "We are happy";
		String[] tmp = t.split(" ");
		String result = "";
		for(int i = 0; i < tmp.length-1; i++){
			result = result + tmp[i] + "%20";
		}
		result += tmp[tmp.length-1];
		System.out.println(result);
	}
}
