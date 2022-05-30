package BinaryTrees;

public class Diameter {
    int max=0;
    //Use modified height function
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;

    }

    int height(TreeNode root){
        if(root==null) return 0;
        int lh= height(root.left);
        int rh= height(root.right);
        max= Math.max(max,lh+rh);
        return 1+Math.max(lh,rh);
    }
}
