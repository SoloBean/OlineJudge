package searchInsertPosition;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target){
		int post = -1;
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i] >= target){ // find position to insert
				post = i;
				break;
			}
		}
		if(post == -1){
			return nums.length;
		}
		
		return post;
	}
	
	public static void main(String[] args){
		SearchInsertPosition t = new SearchInsertPosition();
		int[] nums = new int[]{1,3,5,6};
		int a = t.searchInsert(nums, 0);
		System.out.print(a);
		
	}
}
