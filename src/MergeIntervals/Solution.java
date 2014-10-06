package MergeIntervals;

import Tools.Interval;

import java.util.*;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 2/5/14
 * Time: 9:47 AM
 * Given a collection of intervals, merge all overlapping intervals.
 * <p/>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return null;
        Collections.sort(intervals, new IntervalComparator());
        Stack<Interval> stack = new Stack<Interval>();
        for (Interval i : intervals) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                Interval t = stack.peek();
                if (hasOverlap(t, i)) {
                    Interval newInterval = new Interval(t.start, Math.max(t.end, i.end));
                    stack.pop();
                    stack.push(newInterval);
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

    public boolean hasOverlap(Interval a, Interval b) {
        if (b.start <= a.end) {
            return true;
        } else {
            return false;
        }
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


    static public void main(String[] args) {
        List<Interval> list = Interval.CreateInterval2();
        Interval.PrintInterval(new Solution().merge(list));
    }
}

