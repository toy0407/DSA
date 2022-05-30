package BinaryTrees;

public class MaxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        auxFunc(root);
        return max;
    }

    int auxFunc(TreeNode root) {
        if (root == null) return 0;
        int lh = Math.max(0, auxFunc(root.left));
        int rh = Math.max(0, auxFunc(root.right));
        max = Math.max(max, root.val + lh + rh);
        return root.val + Math.max(lh, rh);
    }

}
