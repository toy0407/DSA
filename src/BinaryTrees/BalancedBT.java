package BinaryTrees;

public class BalancedBT {
    //https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=16
    public boolean isBalanced(TreeNode root) {
        if(height(root)==-1) return false;
        return true;
    }

    int height(TreeNode node){
        if(node==null) return 0;
        int lh=height(node.left);
        int rh=height(node.right);

        if(Math.abs(lh-rh)>1) return -1;
        if(lh==-1 || rh==-1) return -1;

        return 1+Math.max(lh,rh);
    }
}
