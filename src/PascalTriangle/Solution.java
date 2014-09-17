package PascalTriangle;

import Tools.ListTools;

import java.util.LinkedList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/10/14
 * Time: 8:49 PM
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(numRows==0){
            return result;
        }
        List<Integer> firstRow = new LinkedList<Integer>();
        firstRow.add(1);
        result.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new LinkedList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        new ListTools().Print(new Solution().generate(1));
    }
}