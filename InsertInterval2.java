package mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval2 {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval){
		List<Interval> result = new ArrayList<>();
		if(intervals.isEmpty()){
			result.add(newInterval);
			return result;
		}
		int[] start = new int[intervals.size()];
		int[] end = new int[intervals.size()];
		for(int i = 0; i < intervals.size(); i++){
			start[i] = intervals.get(i).start;
			end[i] = intervals.get(i).end;
		}
		int beginValue = newInterval.start;
		int endValue = newInterval.end;
		int beginIndex = intervals.size();
		for(int i = 0; i < intervals.size(); i++){
			if(beginValue > end[i]){
				result.add(new Interval(start[i], end[i]));
			}
			else{
				beginIndex = i;
				break;
			}
		}
		if(beginIndex == intervals.size()){
			result.add(newInterval);
			return result;
		}
		if(beginValue >= start[beginIndex]){
			beginValue = start[beginIndex];
		}
		int endIndex = intervals.size()-1;
		for(int i = beginIndex; i < intervals.size(); i++){
			if(endValue < start[i] ){
				endIndex = i-1;
				break;
			}
		}
		if(endIndex != -1){
			if(endValue <= end[endIndex]){
				endValue = end[endIndex];
			}
		}
		result.add(new Interval(beginValue, endValue));
		if(endIndex == intervals.size()-1){
			return result;
		}
		for(int i = endIndex+1; i < intervals.size(); i++){
			result.add(intervals.get(i));
		}
		return result;
	}
}
