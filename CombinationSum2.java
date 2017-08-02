package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.transform.Templates;

public class CombinationSum2 {
	List<List<Integer>> result = new ArrayList<>();
	int[] store = {};
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        store = candidates;
        Arrays.sort(store);
        BackTracking(new ArrayList<Integer>(), 0, target);
		
		return this.result;
    }
	
	public void BackTracking(List<Integer> cur, int from, int target){
		if(target == 0){
			List<Integer> list = new ArrayList<Integer>(cur);
			if(!result.contains(list)){
				result.add(list);
			}
		}
		else{
			for(int i = from; i < store.length && store[i] <= target; i++){
				cur.add(store[i]);
				BackTracking(cur, i+1, target-store[i]);
				cur.remove(new Integer(store[i]));
			}
		}
	}
}
