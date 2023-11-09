import java.util.*;

class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(minimumAbsoluteDifference(root));

    }

    public static int minimumAbsoluteDifference(TreeNode root) {
        return minDifferenceHelper(root, null, Integer.MAX_VALUE);
    }

    //Helper function
    public static int minDifferenceHelper(TreeNode root, TreeNode prev, int min){
        //In order traversal
        if (root == null) return min;

        int leftSide = minDifferenceHelper(root.left, prev, min);

        if (prev != null) min = Math.min(min, root.val - prev.val);
        prev = root;

        int rightSide = minDifferenceHelper(root.right, prev, min);

        return min;
    }

}
