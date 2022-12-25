package BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class NodesAtDistanceK {
    HashMap<TreeNode,ArrayList<TreeNode>> map = new HashMap<>();
    List<Integer> ans = new ArrayList<>();

    public List<Integer> nodesAtDistanceK(TreeNode root, TreeNode target, int k) {
        buildMap(root,null);
        HashSet<TreeNode> vis = new HashSet<>();
        dfs(target,k, vis);
        return ans;
    }

    void dfs(TreeNode node, int k, HashSet<TreeNode> vis){
        vis.add(node);
        if(k==0) ans.add(node.val);
        for(TreeNode a:map.get(node)){
            if(!vis.contains(a)){
                dfs(a,k-1,vis);
            }
        }
    }



    void buildMap(TreeNode node, TreeNode parent) {
        if (node == null) return;
        map.put(node, new ArrayList<TreeNode>());
        if (parent != null) {
            map.get(node).add(parent);
            map.get(parent).add(node) ;
        }
        buildMap(node.left, node);
        buildMap(node.right, node);
    }

}
