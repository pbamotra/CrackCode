package Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/5/14
 * Time: 8:39 PM
 */
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    static public List<Interval> CreateInterval() {
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(2, 6));
        list.add(new Interval(1, 3));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));
        return list;
    }

    static public List<Interval> CreateInterval2() {
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(2, 6));
        list.add(new Interval(1, 1));

        return list;
    }

    static public void PrintInterval(List<Interval> list) {
        for (Interval i : list) {
            System.out.println(i.start + " " + i.end);
        }
    }
}
