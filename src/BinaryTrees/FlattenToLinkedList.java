package BinaryTrees;

public class FlattenToLinkedList {
    TreeNode prev;
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
}
