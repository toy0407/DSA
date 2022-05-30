package BinarySearchTrees;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }

    boolean isValid(TreeNode node,long l,long r){
        if(node==null) return true;
        if((node.val>=r) ||  (node.val<=l)) return false;
        boolean left=isValid(node.left,l,node.val);
        boolean right=isValid(node.right,node.val,r);
        return left && right;

    }
}
