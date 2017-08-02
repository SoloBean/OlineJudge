package mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval){
		List<Interval> result = new ArrayList<>();
		if(intervals.isEmpty()){
			result.add(newInterval);
			return result;
		}
		int[] start = new int[intervals.size()+1];
		int[] end = new int[intervals.size()+1];
		for(int i = 0; i < intervals.size(); i++){
			start[i] = intervals.get(i).start;
			end[i] = intervals.get(i).end;
		}
		start[intervals.size()] = newInterval.start;
		end[intervals.size()] = newInterval.end;
		Arrays.sort(start);
		Arrays.sort(end);
		for (int i = 0, j = 0; i < intervals.size()+1; i++) { // j is start of interval.
	    	if (i == intervals.size() - 1 || start[i + 1] > end[i]) {
	    		result.add(new Interval(start[j], end[i]));
			    j = i + 1;
		    }
	    }
		return result;
	}
}
