package BinaryTrees;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {

    //Iterative
    void iterativePreorder(TreeNode node) {
        Stack<TreeNode> s = new Stack<>();
        while (node != null || !s.empty()) {
            while (node != null) {
                System.out.println(node.val);
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            node = node.right;
        }
    }

    //Recursive
    void recursivePreorder(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            recursivePreorder(node.left);
            recursivePreorder(node.right);
        }
    }
}
