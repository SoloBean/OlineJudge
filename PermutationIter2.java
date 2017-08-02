package permutation;

import java.util.List;
import java.util.ArrayList;

public class PermutationIter2 {
	public List<List<Integer>> permute(int[] nums){
		
		List<List<Integer>> result = new ArrayList<>();
		if(nums==null || nums.length==0)  
	        return null;
		boolean[] used = new boolean[nums.length];
		back(nums, used, new ArrayList<Integer>(), result);
		return result;
	}
	
	public void back(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result){
		if(list.size() == nums.length){
			result.add(new ArrayList<Integer>(list));
			return;
		}
		else {
			for(int i = 0; i < nums.length; i++){
				if(!used[i]){
					used[i] = true;
					list.add(nums[i]);
					back(nums, used, list, result);
					used[i] = false;
					list.remove(list.size()-1);
				}
			}
		}
	}
	
	public static void main(String[] args){
		PermutationIter2 t = new PermutationIter2();
		int[] nums = new int[]{1,2,3,4};
		List<List<Integer>>	result = t.permute(nums);
		for(int i = 0; i < result.size(); i++){
			for(int j = 0; j < nums.length; j++){
				System.out.print(result.get(i).get(j)+",");
			}
			System.out.println();
		}
	}
}
