package BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    //Iterative using 2 stack
    void iterativePostorder2(TreeNode node) {
        Stack<TreeNode> s1 =new Stack<>();
        Stack<TreeNode> s2=new Stack<>();

        if (node==null) return;
        s1.push(node);

        while(!s1.empty()){
            TreeNode temp=s1.pop();
            s2.push(temp);
            if (temp.left!=null) s1.push(temp.left);
            if (temp.right!=null) s1.push(temp.right);
        }
        while (!s2.empty()){
            System.out.println(s2.pop().val);
        }
    }

    /*Iterative using 1 stack
    https://www.youtube.com/watch?v=NzIGLLwZBS8&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=13
    */
    List<Integer> iterativePostOrder1(TreeNode node){
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        if (node==null) return ans;
        while(node!=null || !s.empty()){
            if (node!=null){
                s.push(node);
                node=node.left;
            }
            else {
                TreeNode temp= s.peek().right;
                if (temp==null) {
                    temp=s.pop();
                    ans.add(temp.val);
                    while(!s.empty() && temp==s.peek().right){
                        temp=s.pop();
                        ans.add(temp.val);
                    }
                }
                else node=temp;
            }
        }
        return ans;
    }

    //Recursive
    void recursivePostorder(TreeNode node) {
        if (node != null) {
            recursivePostorder(node.left);
            recursivePostorder(node.right);
            System.out.println(node.val);
        }
    }
}
