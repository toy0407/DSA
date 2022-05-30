package BinarySearchTrees;

import java.util.ArrayList;
import java.util.Stack;

public class KthSmallestElement {

    /**
     * INORDER traversal in BST gives the array in sorted order.
     */
    ArrayList<Integer> ar=new ArrayList<>();
    public int kthSmallestRecursive(TreeNode root, int k) {
        inOrder(root);
        return ar.get(k-1);
    }
    void inOrder(TreeNode node){
        if(node==null) return;
        inOrder(node.left);
        ar.add(node.val);
        inOrder(node.right);

    }


    public int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> st=new Stack<>();
        int c=0;
        while(!st.empty() || root != null){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            c++;
            if(c==k) return root.val;
            root=root.right;
        }
        return -1;
    }


}
