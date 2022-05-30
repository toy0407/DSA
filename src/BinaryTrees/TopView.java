package BinaryTrees;

import java.util.*;

public class TopView {
    /*
     * Use BFS as DFS might cause issues. In case of BFS, no need to iterate the entire size of the queue as we only require the leftmost and rightmost nodes.
     */
    static TreeMap<Integer, TreeNode> h = new TreeMap<>();

    static class Pair {
        int coordinate;
        TreeNode node;

        public Pair(int val, TreeNode node) {
            this.coordinate = val;
            this.node = node;
        }
    }

    public static ArrayList<Integer> getTopView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Bfs(root);
        for (Map.Entry<Integer, TreeNode> e : h.entrySet()) {
            ans.add(e.getValue().val);
        }
        return ans;
    }

    static void Bfs(TreeNode node) {
        if (node == null) return;
        int x = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, node));
        while (!q.isEmpty()) {
            Pair temp = q.remove();
            x = temp.coordinate;
            if (temp.node.left != null) q.add(new Pair(x - 1, temp.node.left));
            if (temp.node.right != null) q.add(new Pair(x + 1, temp.node.right));
            h.putIfAbsent(temp.coordinate, temp.node);
        }
    }

}
