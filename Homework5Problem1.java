import java.util.*;

class Solution {
    public static void main(String[] args) {
        String s = "()())()";
        System.out.println(s);

        List<String> removedPar = new ArrayList<>();
        removedPar = removeInvalidParenthesis(s);

        System.out.println(removedPar.get(0));
    }

    //Removal function to be used by driver code
    public static List<String> removeInvalidParenthesis(String s) {
        List<String> results = new ArrayList<>();
        if(s.length() <= 20)
          removalHelper(s, results, 0, 0, false);

        return results;
    }

    //Removal helper function
    public static void removalHelper(String s, List<String> results, int left, int right, Boolean reversed){
        for (int i = left; i < s.length(); i++) {
            int openPar = 0;
            int closedPar = 0;

            if (reversed != false) { //Going through the string normally
                //Adding open and closed parentheses
                if (s.charAt(i) == '(') openPar++;
                else if (s.charAt(i) == ')') closedPar++;
                if (closedPar > openPar) { //If there are more closed parentheses than open ones
                    for (int j = right; j <= i; j++) {
                        //Run through string to remove extras at position
                        if (s.charAt(j) == ')' && (j == right || s.charAt(j-1) != ')'))
                        removalHelper(s.substring(0, j) + s.substring(j + 1, s.length()), results, i, j, reversed);
                        return;
                    }
                }
            }
            else { //Ditto, but in reverse
                if (s.charAt(i) == ')') openPar++;
                else if (s.charAt(i) == '(') closedPar++;
                if (closedPar > openPar) {
                    for (int j = right; j <= i; j++) {
                        if (s.charAt(j) == '(' && (j == right || s.charAt(j-1) != '('))
                        removalHelper(s.substring(0, j) + s.substring(j + 1, s.length()), results, i, j, reversed);
                        return;
                    }
                }
            }
        }
        String s2 = new StringBuilder(s).reverse().toString();
        //Run through string in reverse
        if (reversed == false) removalHelper(s2, results, 0, 0, true);
        //add string to results otherwise
        else results.add(s2);
    }
}
