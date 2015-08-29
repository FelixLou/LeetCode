Question: http://www.lintcode.com/en/problem/merge-intervals/
```
My Solution 1:
public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
 
		if (intervals == null || intervals.size() <= 1)
			return intervals;
 
		// sort intervals by using self-defined Comparator
		Collections.sort(intervals, new IntervalComparator());
 
		List<Interval> result = new ArrayList<Interval>();
 
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
 
			if (prev.end >= curr.start) {
				// merged case
				Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev = merged;
			} else {
				result.add(prev);
				prev = curr;
			}
		}
		result.add(prev);
 
		return result;
	}
}
 
class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}
///////////////////////////
class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            return result;
        }
        Collections.sort(intervals, new IntervalComparator());
        int i = 0;
        while (i < intervals.size()){
            int left = i;
            int max = intervals.get(i).end;
            if (i < intervals.size() - 1 && max >= intervals.get(i + 1).start){
                while (i < intervals.size() - 1 && max >= intervals.get(i + 1).start){
                    i++;
                    max = Math.max(intervals.get(i).end, max);
                }
                result.add(new Interval(intervals.get(left).start, max));
            }
            else{
                result.add(intervals.get(i));
            }
            i++;
        }
        return result;
    }
}
/////////////////////
Renjia's solution:
    public List<Interval> merge(List<Interval> intervals) {
    if (intervals == null || intervals.isEmpty())
        return intervals;
    Collections.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval i1, Interval i2) {
            if (i1.start != i2.start) {
                return i1.start - i2.start;
            }
            return i1.end - i2.end;
        }
    });
    ListIterator<Interval> it = intervals.listIterator();
    Interval cur = it.next();
    while (it.hasNext()) {
        Interval next = it.next();
        if (cur.end < next.start) {
            cur = next;
            continue;
        } else {
            cur.end = Math.max(cur.end, next.end);
            it.remove();
        }
    }
    return intervals;
}
/////////////////////
public List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() <= 1)
        return intervals;

    // Sort by ascending starting point using an anonymous Comparator
    Collections.sort(intervals, new Comparator<Interval>() {
        @Override
        public int compare(Interval i1, Interval i2) {
            return Integer.compare(i1.start, i2.start);
        }
    });

    List<Interval> result = new LinkedList<Interval>();
    int start = intervals.get(0).start;
    int end = intervals.get(0).end;

    for (Interval interval : intervals) {
        if (interval.start <= end) // Overlapping intervals, move the end if needed
            end = Math.max(end, interval.end);
        else {                     // Disjoint intervals, add the previous one and reset bounds
            result.add(new Interval(start, end));
            start = interval.start;
            end = interval.end;
        }
    }

    // Add the last interval
    result.add(new Interval(start, end));
    return result;
}
