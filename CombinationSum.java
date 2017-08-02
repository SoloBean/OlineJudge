package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	List<List<Integer>> result = new ArrayList<>();
	int[] tmp = {};
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.tmp = candidates;
        Arrays.sort(tmp);
        backTrack(new ArrayList(), 0, target);
        
        return this.result;
    }
	
	public void backTrack(List<Integer> cur, int from, int target){
		if(target == 0){
			List<Integer> list = new ArrayList<Integer>(cur);
			result.add(list);
			return;
		}
		
		else if(target < 0){
			return;
		}
		else {
			for(int i = from; i < tmp.length && tmp[i] <= target; i++){
				cur.add(tmp[i]);
				backTrack(cur, i, target-tmp[i]);
				cur.remove(new Integer(tmp[i]));
			}
		}
	}
	
	public static void main(String[] args){
		List<Integer> cur = new ArrayList<>();
		cur.add(1);
		cur.add(2);
		List<Integer> list = new ArrayList<Integer>(cur);
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
}
