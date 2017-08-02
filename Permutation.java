package permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
        	list.add(nums[i]);
        }
        result.add(list);
        
        for(int i = 0; i < nums.length-1; i++){
        	int length = result.size();
        	for(int j = i+1; j < nums.length; j++){
        		for(int k = 0; k < length; k++){
        			result.add(change(i,j,result.get(k)));
        		}
        	}
        }
        
        return result;
    }
	
	public List<Integer> change(int begin, int end, List<Integer> list){
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < list.size(); i++){
			result.add(list.get(i));
		}
		int t = result.get(begin);
		result.set(begin, result.get(end));
		result.set(end, t);
		return result;
	}
	
	public static void main(String[] args){
		Permutation t = new Permutation();
		int[] nums = new int[]{1,2,3};
		List<List<Integer>>	result = t.permute(nums);
		for(int i = 0; i < result.size(); i++){
			for(int j = 0; j < nums.length; j++){
				System.out.print(result.get(i).get(j)+",");
			}
			System.out.println();
		}
	}
}
