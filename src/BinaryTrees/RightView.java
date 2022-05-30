package BinaryTrees;

import java.util.*;

public class RightView {
    HashMap<Integer, Integer> h = new HashMap<>();

    class Pair {
        int level;
        TreeNode node;

        Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        bfs(root);
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        for (Map.Entry<Integer, Integer> e : h.entrySet()) {
            ans.add(e.getValue());
        }
        return ans;

    }

    void bfs(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int level = 0;
        if (root == null) return;
        q.add(new Pair(level, root));
        while (!q.isEmpty()) {
            Pair temp = q.remove();
            level = temp.level;
            if (temp.node.left != null) q.add(new Pair(level + 1, temp.node.left));
            if (temp.node.right != null) q.add(new Pair(level + 1, temp.node.right));
            h.put(level, temp.node.val);
        }
    }
}
