package searchRange;

public class SearchRange {
	int[] tmp = {};
	public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        this.tmp = nums;
        int position = searchTarget(0, nums.length-1, target);
        if(position == -1){
        	return new int[]{-1,-1};
        }
        else if(position == 0){
        	//search behind
        	result[0] = 0;
        	result[1] = searchBehind(position, target);
        }
        else if(position == nums.length-1){
        	//search forward
        	result[0] = searchFront(position, target);
        	result[1] = position;
        }
        else{
        	result[0] = searchFront(position, target);
        	result[1] = searchBehind(position, target);
        }
        return result;
    }
	
	public int searchTarget(int begin, int end, int target){
		int position = (begin+end)/2;
		if(end < begin){
			return -1;
		}
		if(end - begin <= 1){
			if(tmp[begin] == target){
				return begin;
			}
			else if(tmp[end] == target){
				return end;
			}
			else{
				return -1;
			}
		}
		if(tmp[position] == target){
			return position;
		}
		else if(tmp[position] < target){
			if(tmp[position+1] > target){
				return -1;
			}
			return searchTarget(position + 1, end, target);
		}
		else {
			if(tmp[position-1] < target){
				return -1;
			}
			return searchTarget(begin, position-1, target);
		}
	}
	
	public int searchFront(int position, int target){
		int tmp_position = searchTarget(0, position-1, target);
		int result = position;
		while(tmp_position != -1){
			if(tmp_position == 0){
				return 0;
			}
			result = tmp_position;
			position = tmp_position;
			tmp_position = searchTarget(0, position-1, target);
		}
		
		return result;
	}
	
	public int searchBehind(int position, int target){
		int last = this.tmp.length-1;
		int temp_position = searchTarget(position +1, last, target);
		int result = position;
		while(temp_position != -1){
			if(temp_position == last){
				return last;
			}
			result = temp_position;
			position = temp_position;
			temp_position = searchTarget(position+1, last, target);
		}
		return result;
	}
	
	public static void main(String[] args){
		SearchRange t = new SearchRange();
		int[] nums = new int[]{5, 7, 7, 8, 8, 10};
		int[] result = t.searchRange(nums, 8);
		int position = t.searchTarget(0, nums.length-1, 8);
		System.out.println("1="+result[0]+ " 2=" + result[1]);
		System.out.println(position);
		
	}
}
