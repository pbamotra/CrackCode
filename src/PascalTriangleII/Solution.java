package PascalTriangleII;

import Tools.ListTools;

import java.util.LinkedList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/10/14
 * Time: 9:13 PM
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> row = new LinkedList<Integer>();
        row.add(1);
        if (rowIndex == 0) return row;
        row.add(1);
        if (rowIndex == 1) return row;
        LinkedList<Integer> previous = row;
        for (int i = 1; i < rowIndex + 1; i++) {
            LinkedList<Integer> r = new LinkedList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    r.add(1);
                } else {
                    r.add(previous.get(j - 1) + previous.get(j));
                }
            }
            previous = r;
        }
        return previous;
    }

    public static void main(String[] args) {
        new ListTools().PrintList(new Solution().getRow(2));
    }
}
