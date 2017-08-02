package jumpGame;

public class JumpGameSolution {
	public boolean canJump(int[] nums){
		if(nums.length == 1){
			return true;
		}
		if(nums[0] == 0){
			return false;
		}
		int lastIndex = nums.length - 2;
		int point  = lastIndex;
		while(point > 0){
			if(nums[point] == 0){
				point = jumpPosition(nums,point);
			}
			if(point == -1){
				return false;
			}
			point--;
		}
		return true;
	}
	
	public int jumpPosition(int[] nums, int point){
		point--;
		int count = 1;
		while(nums[point] <= count && point >= 1){
			point--;
			count++;
		}
		if(point == 0){
			if(nums[0] <= count){
				return -1;
			}
		}
		return point;
	}
	
	public static void main(String[] args){
		JumpGameSolution t = new JumpGameSolution();
		int[] nums = new int[]{0};
		System.out.println(t.canJump(nums));
	}
}
