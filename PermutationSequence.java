package permutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	private final int[] RATE = new int[]{0,1,2,6,24,120,720,5040,40320,362880};
	public String getPermutation(int n, int k){
		if(n == 1){
			return "1";
		}
		List<Integer> candidate = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			candidate.add(i+1);
		}
		StringBuilder res = new StringBuilder();
		
		for(int i = n-1; i >= 1; i--){
			if(k % RATE[i] == 0){
				int point = k/RATE[i];
				res.append(candidate.get(point-1));
				candidate.remove(point-1);
				for(int j = candidate.size()-1; j >= 0; j--){
					res.append(candidate.get(j));
				}
				return res.toString();
			}
			else{
				int point = k/RATE[i] + 1;
				res.append(candidate.get(point-1));
				candidate.remove(point-1);
				k = k - (point-1)*RATE[i];
			}
		}
		
		return res.toString();
	}
	
	public static void main(String[] args){
		PermutationSequence t = new PermutationSequence();
		String tmp = t.getPermutation(4, 17);
		System.out.println(tmp);
		
	}
}
