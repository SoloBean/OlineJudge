package jumpGame;

import java.util.ArrayList;
import java.util.List;

public class JumpGame2 {
	public int jump(int[] nums) {
		int[] distance = new int[nums.length];
		for(int i = nums.length-2; i >= 0; i--){
			distance[i] = subSolution(nums, distance, i);
		}
		
		return distance[0];
    }
	//i reach last index need how many steps
	public int subSolution(int[] nums, int[] distance, int i){
		int min = Integer.MAX_VALUE;
		if(nums[i] >= nums.length - i - 1){
			return 1;
		}
		else{
			for(int j = nums[i]; j >= 1; j--){
				if(distance[j+i] == 1){
					return 2;
				}
				if(distance[j+i] < min){
					min = distance[j+i];
				}
			}
		}
		if(min == Integer.MAX_VALUE){
			return min;
		}
		else{
			return min+1;
		}
	}
	
	
	public static void main(String[] args){
		JumpGame2 t  = new JumpGame2();
		int[] nums = new int[]{4,3,2,1,1,0};
		int step = t.jump(nums);
		System.out.println(step);
	}
}
