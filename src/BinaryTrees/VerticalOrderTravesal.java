package BinaryTrees;

import java.util.*;

public class VerticalOrderTravesal {
    //TODO: Complete this function
    class Coordinates{
        int x,y,val;

        public Coordinates(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    List<List<Integer>> ans=new ArrayList<>();
    List<Coordinates> list=new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        preOrder(root,0,0);

        return ans;
    }

    void preOrder(TreeNode node,int x,int y){
        if (node==null) return;
        list.add(new Coordinates(x,y,node.val));
        preOrder(node.left,x-1,y+1);
        preOrder(node.right,x+1,y+1);
    }

}
