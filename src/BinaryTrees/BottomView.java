package BinaryTrees;

import org.w3c.dom.Node;

import java.util.*;

public class BottomView {
    class Pair{
        int x;
        TreeNode node;
        Pair(int x,TreeNode node){
            this.x=x;
            this.node=node;
        }
    }

    TreeMap<Integer,Integer> h=new TreeMap<>();

    //Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(TreeNode root)
    {
        // Code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        bfs(root);
        for(Map.Entry<Integer,Integer> e: h.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }


    void bfs(TreeNode root){
        if(root==null) return;
        Queue<Pair> q=new LinkedList<>();
        int x=0;
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair temp=q.remove();
            x=temp.x;
            if(temp.node.left!=null) q.add(new Pair(x-1,temp.node.left));
            if(temp.node.right!=null) q.add(new Pair(x+1,temp.node.right));
            h.put(x,temp.node.val);
        }
    }
}
