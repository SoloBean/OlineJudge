package maximumSubarray;

public class MaxSubarray {
	public int maxSubArray(int[] nums){
		int[] sum = new int[nums.length];
		int max = Integer.MIN_VALUE;
		sum[0] = nums[0];
		max = sum[0];
		for(int i = 1; i < nums.length; i++){
			if(sum[i-1] > 0){
				sum[i] = sum[i-1] + nums[i];
			}
			else{
				sum[i] = nums[i];
			}
			if(sum[i] > max){
				max = sum[i];
			}
		}
		return max;
	}
	
}
