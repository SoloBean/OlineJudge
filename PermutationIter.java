package permutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationIter {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {  
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
	    if(num==null || num.length==0)  
	        return res;  
	    helper(num, new boolean[num.length], new ArrayList<Integer>(), res);  
	    return res;  
	}
	
	private void helper(int[] num, boolean[] used, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res)  
	{  
	    if(item.size() == num.length)  
	    {  
	        res.add(new ArrayList<Integer>(item));  
	        return;  
	    }  
	    for(int i=0;i<num.length;i++)  
	    {  
	        if(!used[i])  
	        {  
	            used[i] = true;  
	            item.add(num[i]);  
	            helper(num, used, item, res);  
	            item.remove(item.size()-1);  
	            used[i] = false;  
	        }  
	    }  
	}  
	
	public static void main(String[] args){
		PermutationIter t = new PermutationIter();
		int[] nums = new int[]{1,2,3};
		List<ArrayList<Integer>> result = t.permute(nums);
		for(int i = 0; i < result.size(); i++){
			for(int j = 0; j < nums.length; j++){
				System.out.print(result.get(i).get(j)+",");
			}
			System.out.println();
		}
	}
}
