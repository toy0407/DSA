package BinaryTrees;
import java.util.*;

public class BoundaryTraversal {

    /**
     * Traverse the array in Anti Clockwise Direction and printing all the boundary nodes.
     * https://www.youtube.com/watch?v=0ca1nvR0be4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=21
     */


     List<Integer> ans=new ArrayList<>();

    //Add the left Boundary without leaf nodes
    void LeftBoundary(TreeNode node){
        TreeNode cur=node.left;
        while(cur!=null){
            if(!isLeaf(cur)) ans.add(cur.val);
            if(cur.left!=null) cur=cur.left;
            else cur=cur.right;
        }
    }
    //Add the right boundary in reverse order without the leaf nodes
    void RightBoundary(TreeNode node){
        TreeNode cur=node.right;
        ArrayList<Integer> sub=new ArrayList<>();
        while(cur!=null){
            if(!isLeaf(cur)) sub.add(cur.val);
            if(cur.right!=null)cur=cur.right;
            else cur=cur.left;
        }
        Collections.reverse(sub);
        ans.addAll(sub);
    }
    //Add the leaf nodes
    void addLeaves(TreeNode node){
        if(isLeaf(node)){
            ans.add(node.val);
            return;
        }
        if(node.left!=null) addLeaves(node.left);
        if(node.right!=null) addLeaves(node.right);
    }
    //Check if the node is a leaf node
    boolean isLeaf(TreeNode node){
        if(node.left==null && node.right==null) return true;
        return false;
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root==null) return ans;
        //Add the root node if it is not a leaf node
        if(!isLeaf(root)){
            ans.add(root.val);
        }
        LeftBoundary(root);
        addLeaves(root);
        RightBoundary(root);
        return ans;
    }
}
