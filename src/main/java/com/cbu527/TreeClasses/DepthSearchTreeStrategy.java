package com.cbu527.TreeClasses;

import java.util.Stack;

public class DepthSearchTreeStrategy implements MainInterface{

    public void print(TreeNode pRoot) {
        if(pRoot == null)
            return;
        System.out.print("DFS: ");
        Stack<TreeNode> res = new Stack<TreeNode>();
        res.add(pRoot);
        while(res.size()>0){
            TreeNode top = res.pop();
            System.out.print(top.getItem() + " ");
            if(top.getLeft()!=null)
                res.add(top.getLeft());
            if(top.getRight()!=null)
                res.add(top.getRight());

        }
        System.out.print("\n");
    }
}
