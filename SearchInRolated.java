package searchinRotated;

public class SearchInRolated {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0){
            return false;
        }
        if (nums.length == 1){
            return nums[0] == target;
        }
        int l = 0, r = nums.length-1;
        while (l<r-1){
            int middle = (l+r)/2;
            if (nums[middle] == target || nums[l] == target || nums[r] == target){
                return true;
            }
            if (nums[l] == nums[r]){
                for (int i = l; i <= r; i++){
                    if (target == nums[i]){
                        return true;
                    }
                }
                return false;
            }
            if (nums[middle] >= nums[l]){
                if (target > nums[l] && target < nums[middle]){
                    r = middle;
                }
                else {
                    l = middle;
                }
            }
            else if (nums[middle] <= nums[r]){
                if (target < nums[r] && target > nums[middle]){
                    l = middle;
                }
                else {
                    r = middle;
                }
            }
            else {
                return false;
            }
        }
        if (nums[l] == target || nums[r] == target){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] arg){
        SearchInRolated t = new SearchInRolated();
        int[] nums = new int[]{3,1,2,2,2};
        System.out.println(t.search(nums,1));
    }
}
