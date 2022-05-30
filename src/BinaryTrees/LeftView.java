package BinaryTrees;

import java.util.*;

public class LeftView {
    class Pair {
        int level;
        TreeNode node;

        Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    HashMap<Integer, Integer> h = new HashMap<>();

    ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        bfs(root);
        for (Map.Entry<Integer, Integer> e : h.entrySet()) {
            ans.add(e.getValue());
        }
        return ans;

    }

    void bfs(TreeNode root) {
        if (root == null) return;
        Queue<Pair> q = new LinkedList<>();
        int level = 0;
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair temp = q.remove();
            level = temp.level;
            if (temp.node.left != null) q.add(new Pair(level + 1, temp.node.left));
            if (temp.node.right != null) q.add(new Pair(level + 1, temp.node.right));
            h.putIfAbsent(level, temp.node.val);
        }
    }
}
