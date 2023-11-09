import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> results = new ArrayList<Integer>();
        lexNumHelper(results, n, 1);
        return results;
    }

    public static void lexNumHelper(List<Integer> results, int n, int curNum) {
        //Recursively go through numbers 1 to 9, per 10s
        //Should result in Lexographical order
        if (curNum <= n) { //While in bounds
            results.add(curNum);
            lexNumHelper(results, n, curNum*10);
            if (curNum % 10 < 9) //Go through 1 to 9
            lexNumHelper(results, n, curNum+1);
        }
    }
}
