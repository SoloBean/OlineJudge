package subSet;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length == 0){
            return null;
        }
        else {
            for (int k = 1; k <= length; k++){
                back(0, length, k, res, new ArrayList<>(), nums);
            }
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }

        return res;
    }

    public void back(int begin, int n, int k, List<List<Integer>> res, List<Integer> list, int[] nums){
        if (k == 0){
            List<Integer> tmp = new ArrayList<>(list);
            res.add(tmp);
        }
        else {
            for (int i = begin; i < n-k+1; i++){
                list.add(nums[i]);
                back(i+1, n, k-1, res, list, nums);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args){
        SubSet t = new SubSet();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = t.subsets(nums);
        for (int i = 0; i < res.size(); i++){
            for (int j = 0; j < res.get(i).size(); j++){
                System.out.print(res.get(i).get(j)+",");
            }
            System.out.println();
        }
    }
}
