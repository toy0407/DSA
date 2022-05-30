package BinaryTrees;

import java.util.*;

public class BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return ans;
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);
                sub.add(queue.poll().val);
            }
            ans.add(new ArrayList<>(sub));
        }
        return ans;
    }
}
