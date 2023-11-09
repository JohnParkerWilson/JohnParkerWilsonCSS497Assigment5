import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(MaximumPathSum(root));
    }

    public static int MaximumPathSum(TreeNode root) {
        return MaxPathHelper(root, 0);
    }

    public static int MaxPathHelper(TreeNode root, int max) {
        if(root == null) return 0;

        //Get the Maximum of left and right subtrees
        //Traversal Preorder
        int leftMax = MaxPathHelper(root.left, max);
        int rightMax = MaxPathHelper(root.right, max);

        //get the maximum between the current node vauel and the maximums of the left/right trees
        int thisMax = Math.max(root.val, Math.max(leftMax, rightMax) + root.val);

        //Get the maximum between previous maximum and maximum of left/right trees
        int totalMax = Math.max(thisMax, root.val + leftMax + rightMax);

        //Get max of whole tree
        max = Math.max(max, totalMax);

        return totalMax;
    }

}
