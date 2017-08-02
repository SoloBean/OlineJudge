package mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MyComparator implements Comparator<Interval>{
	public int compare(Interval a, Interval b){
		if(a.start < b.start){
			return -1;
		}
		else if(a.start > b.start){
			return 1;
		}
		else{
			if(a.end > b.end){
				return 1;
			}
			else if(a.end < b.end){
				return -1;
			}
			else{
				return 0;
			}
		}
	}
}

public class MergeIntervals {
	 public List<Interval> merge(List<Interval> intervals) {
		 List<Interval> result = new ArrayList<>();
		 MyComparator cmp = new MyComparator();
		 Collections.sort(intervals, cmp);
		 if(intervals.size() == 0){
			 return result;
		 }
		 if(intervals.size() == 1){
			 return intervals;
		 }
		 int begin = intervals.get(0).start;
		 int end = intervals.get(0).end;
		 for(int i = 1; i < intervals.size()-1; i++){
			 if(intervals.get(i).start <= end){
				 if(intervals.get(i).end > end){
					 end = intervals.get(i).end;
				 }
				 continue;
			 }
			 else{
				 Interval t = new Interval(begin, end);
				 begin = intervals.get(i).start;
				 end = intervals.get(i).end;
				 result.add(t);
			 }
		 }
		 if(intervals.get(intervals.size()-1).start <= end){
			 if(intervals.get(intervals.size()-1).end > end){
				 end = intervals.get(intervals.size()-1).end;
			 }
			 Interval t = new Interval(begin, end);
			 result.add(t);
		 }
		 else{
			 Interval t = new Interval(begin, end);
			 result.add(t);
			 result.add(intervals.get(intervals.size()-1));
		 }
		 
		 return result;
	 }
	 
	 public void sort(List<Interval> intervals){
		 
	 }
	 
	 public static void main(String[] args){
		 
	 }
}
