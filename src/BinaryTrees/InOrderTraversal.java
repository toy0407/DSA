package BinaryTrees;

import java.util.Stack;

public class InOrderTraversal {
    //Iterative
    void iterativeInorder(TreeNode node) {
        Stack<TreeNode> s = new Stack<>();
        while (!s.empty() || node != null) {
            while (node != null) {
                s.push(node);
                node = node.left;

            }
            node = s.pop();
            System.out.println(node.val);
            node = node.right;
        }
    }

    //Recursive
    void recursiveInorder(TreeNode node) {
        if (node != null) {
            recursiveInorder(node.left);
            System.out.println(node.val);
            recursiveInorder(node.right);
        }
    }
}
