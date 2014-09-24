package Tools;

import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/10/14
 * Time: 8:56 PM
 */
public class ListTools {
    static public void Print(List<List<Integer>> l) {
        for (List<Integer> list : l) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\r\n");
        }
    }

    static public void Print(char[][] l) {
        for(char[] list:l){
            for(char c:list){
                System.out.print(c+" ");
            }
            System.out.print("\r\n");
        }
    }

    static public void Print(int[][] l) {
        for (int[] list : l) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\r\n");
        }
    }

    static public void PrintIntegerList(List<Integer> l) {
        for (Integer i : l) {
            System.out.print(i + " ");
        }
        System.out.print("\r\n");
    }

    static public void PrintStringList(List<String> l) {
        for (String i : l) {
            System.out.print(i + " ");
        }
        System.out.print("\r\n");
    }

    static public void Print(int[] l) {
        for (Integer i : l) {
            System.out.print(i + " ");
        }
        System.out.print("\r\n");
    }
}
