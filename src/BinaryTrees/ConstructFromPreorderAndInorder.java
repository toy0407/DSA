package BinaryTrees;

import java.util.*;

public class ConstructFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            h.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, h);
    }

    TreeNode build(int[] inOrder, int inStart, int inEnd, int[] preOrder, int preStart, int preEnd, HashMap<Integer, Integer> h) {
        if (inStart > inEnd || preStart > preEnd) return null;
        TreeNode root = new TreeNode(preOrder[preStart]);

        int partition = h.get(root.val);

        root.left = build(inOrder, inStart, partition - 1, preOrder, preStart + 1, preStart + partition - inStart, h);
        root.right = build(inOrder, partition + 1, inEnd, preOrder, preStart + partition - inStart + 1, preEnd, h);
        return root;

    }


}
