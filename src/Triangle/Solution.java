package Triangle;

import java.util.LinkedList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 4:47 PM
 * <p/>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    int value = triangle.get(i - 1).get(j) + triangle.get(i).get(j);
                    triangle.get(i).set(j, value);
                } else if (j == i) {
                    int value = triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j);
                    triangle.get(i).set(j, value);
                } else {
                    int a = triangle.get(i - 1).get(j) + triangle.get(i).get(j);
                    int b = triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j);
                    int value = a < b ? a : b;
                    triangle.get(i).set(j, value);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < triangle.get(triangle.size() - 1).size(); j++) {
            if (triangle.get(triangle.size() - 1).get(j) < min)
                min = triangle.get(triangle.size() - 1).get(j);
        }

        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new LinkedList<List<Integer>>();
        List<Integer> t = new LinkedList<Integer>();
        t.add(2);
        triangle.add(t);
        t = new LinkedList<Integer>();
        t.add(3);
        t.add(4);
        triangle.add(t);
        t = new LinkedList<Integer>();
        t.add(6);
        t.add(5);
        t.add(7);
        triangle.add(t);
        t = new LinkedList<Integer>();
        t.add(4);
        t.add(1);
        t.add(8);
        t.add(3);
        triangle.add(t);
        System.out.print(new Solution().minimumTotal(triangle));
    }


}
