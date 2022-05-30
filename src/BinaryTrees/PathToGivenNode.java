package BinaryTrees;

import java.util.ArrayList;

/**
 * InOrder Traversal to print path to node
 * https://www.youtube.com/watch?v=fmflMqVOC7k&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=27
 */


public class PathToGivenNode {
    public ArrayList<Integer> pathToNode(TreeNode A, int B) {
        ArrayList<Integer> ans=new ArrayList<>();
        inOrder(A,B,ans);
        return ans;

    }

    boolean inOrder(TreeNode node,int b,ArrayList<Integer> ans){
        if(node==null) return false;
        ans.add(node.val);
        if(node.val==b) return true;
        if(inOrder(node.left,b,ans) || inOrder(node.right,b,ans)) return true;
        ans.remove(ans.size()-1);
        return false;

    }
}
