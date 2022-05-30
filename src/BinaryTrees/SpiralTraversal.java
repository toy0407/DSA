package BinaryTrees;

import java.util.*;

public class SpiralTraversal {
    /**Just Reverse the sub array when flag==true
    *https://www.youtube.com/watch?v=3OXWEdlIGl4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=20
    */
     public List<List<Integer>> zigzagLevelOrder(TreeNode node) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        if (node==null) return ans;
        boolean flag=false;
        q.add(node);

        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> sub=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(q.peek().left!=null) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);
                sub.add(q.poll().val);
            }
            if(flag) Collections.reverse(sub);
            ans.add(new ArrayList<>(sub));
            flag=!flag;
        }
        return ans;
    }
}
