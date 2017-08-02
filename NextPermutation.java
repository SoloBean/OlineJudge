package nextPermutation;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int post = -1;
//		for(int i = 1; i < nums.length; i++){
//			if(nums[i] > nums[i-1]){
//				post = i;
//			}
//		}
		for(int i = nums.length-1; i>0; i--){
			if(nums[i] >= nums[i-1]){
				post = i;
				break;
			}
		}
		if(post == -1){
			post = 0;
		}
		else{
			int point = -1;
			for(int j = post; j < nums.length; j++){
				if(nums[j] > nums[post-1]){
					point = j;
				}
			}
			
			change(nums, post-1, point);
		}
		ArrayRotateTwo(nums, post);
	}
	
	public void change(int[] nums, int x, int y){
		int t = 0;
		t = nums[x];
		nums[x] = nums[y];
		nums[y] = t;
	}
	
	public void ArrayRotateTwo(int[] arr, int begin){
		for(int x = begin, y = arr.length -1 ; x < y; x++, y--){
			change(arr, x, y);
		}
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{1,3,5,4,2};
		NextPermutation t = new NextPermutation();
		t.nextPermutation(nums);
		//t.change(nums, 0, 1);
		for (int i : nums) {  
            System.out.print(i+" ");  
        } 
	}
}
