package Tools;

import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/10/14
 * Time: 8:56 PM
 */
public class ListTools {
    static public void PrintListList(List<List<Integer>> l) {
        for (List<Integer> list : l) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\r\n");
        }
    }
}
