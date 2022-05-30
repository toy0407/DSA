package BinarySearchTrees;


public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        dfs(root,val);
        return root;
    }

    void dfs(TreeNode node,int val){
        if(node.val<val){
            //right
            if(node.right==null) node.right=new TreeNode(val);
            else dfs(node.right,val);
        }
        else{
            //left
            if(node.left==null) node.left=new TreeNode(val);
            else dfs(node.left,val);
        }
    }
}
