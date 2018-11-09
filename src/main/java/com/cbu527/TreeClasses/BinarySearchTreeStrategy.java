package com.cbu527.TreeClasses;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BinarySearchTreeStrategy implements MainInterface{
    public void print(TreeNode pRoot) {
        if(pRoot == null)
            return;
        System.out.print("BFS: ");
        Queue<TreeNode> queue= new ConcurrentLinkedQueue<TreeNode>();
        queue.add(pRoot);
        while (queue.size()>0)
        {

            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.getItem() + " ");

            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }


        }
        System.out.print("\n");
    }
}
