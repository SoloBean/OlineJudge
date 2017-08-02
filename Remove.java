package removeDuplicates;

import java.util.ArrayList;
import java.util.List;

public class Remove {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2){
            return nums.length;
        }
        List<Integer> res = new ArrayList<>();
        int tmp = nums[0], count = 1;
        res.add(nums[0]);
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == tmp){
                if (count < 2){
                    res.add(nums[i]);
                    count++;
                }
            }
            else {
                tmp = nums[i];
                count = 1;
                res.add(nums[i]);
            }
        }
        for (int i = 0; i< res.size(); i++){
            nums[i] = res.get(i);
        }
        return res.size();
    }

    public int removeDuplicates2(int[] nums){
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length, flag = 1;
        int pos = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] != nums[pos]) {
                ++pos;
                nums[pos] = nums[i];
                flag = 1;
            }
            else {
                if (flag == 1) {
                    flag = 2;
                    ++pos;
                    nums[pos] = nums[i];
                }
            }
        }
        return pos + 1;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,1,1,2,2,2};
        Remove t = new Remove();
        int length = t.removeDuplicates2(nums);
        System.out.println(length);
    }
}
