package findStartSubstring;

import java.util.ArrayList;
import java.util.List;

public class FindStartSubstringSolution {
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        int baseLength = words[0].length();
        int length = words.length;
        int[][] hash = new int[26][length];
        int[] hashLength = new int[26];
        for(int i = 0 ; i < 26; i++){
        	hashLength[i] = -1;
        }
        for(int i = 0; i < length; i++){
        	String tmp = words[i];
        	int b = (int)tmp.charAt(0) - 97;
        	hashLength[b]++;
        	hash[b][hashLength[b]] = i;
        }
        boolean flag = false;
        
        
        
        for(int i = 0; i < s.length() - 3; i = i + baseLength){
        	String tmp = s.substring(i, i+3);
        	int letter = (int)tmp.charAt(0)-97;
        	int j = 0;
        	for(; j <= hashLength[letter]; j++){
        		if(tmp.equals(words[hash[letter][j]])){
        			if(!flag){
        				flag = true;
        				result.add(i);
        			}
        			break;
        		}
        	}
        	if(j > hashLength[letter]){
        		flag = false;
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args){
		String s = "barfoofoobarthefoobarman";
		String[] words = new String[]{"bar","foo","the"};
		FindStartSubstringSolution t = new FindStartSubstringSolution();
		List<Integer> result = t.findSubstring(s, words);
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}
	}
}
