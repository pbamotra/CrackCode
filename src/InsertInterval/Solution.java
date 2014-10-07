package InsertInterval;

import Tools.Interval;

import java.util.*;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/6/14
 * Time: 8:07 PM
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null) return null;
        intervals.add(newInterval);
        Collections.sort(intervals, new IntervalComparator());
        Stack<Interval> stack = new Stack<Interval>();
        for (Interval i : intervals) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                Interval t = stack.peek();
                if (hasOverlap(t, i)) {
                    Interval newInterval2 = new Interval(t.start, Math.max(t.end, i.end));
                    stack.pop();
                    stack.push(newInterval2);
                } else {
                    stack.push(i);
                }
            }
        }
        int length = stack.size() - 1;
        Interval[] intervalArray = new Interval[stack.size()];
        for (int i = length; i >= 0; i--) {
            intervalArray[i] = stack.pop();
        }
        return Arrays.asList(intervalArray);
    }

    public class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            if (a.start < b.start) {
                return -1;
            } else if (a.start == b.start) {
                if (a.end < b.end) {
                    return -1;
                } else if (a.end == b.end) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }

    public boolean hasOverlap(Interval a, Interval b) {
        if (b.start <= a.end) {
            return true;
        } else {
            return false;
        }
    }
}
