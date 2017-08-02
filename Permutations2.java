package permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Permutations2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Set<String> cache = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
        	list.add(nums[i]);
        }
        result.add(list);
        cache.add(list.toString());
        for(int i = 0; i < nums.length-1; i++){
        	int length = result.size();
        	for(int j = i+1; j < nums.length; j++){
        		for(int k = 0; k < length; k++){
        			List<Integer> tmp = change(i,j,result.get(k));
        			if(cache.add(tmp.toString())){
        				result.add(tmp);
        			}
        		}
        	}
        }
        
        
        return result;
    }
	public void PrintList(List<Integer> list){
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i));
		}
		System.out.println();
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
		Permutations2 t = new Permutations2();
		int[] nums = new int[]{3,2,1,1};
		List<List<Integer>>	result = t.permuteUnique(nums);
		int sum = 0;
		for(int i = 0; i < result.size(); i++){
			for(int j = 0; j < nums.length; j++){
				System.out.print(result.get(i).get(j)+",");
			}
			System.out.println();
//			sum++;
		}
//		System.out.println(sum);
	}
}
