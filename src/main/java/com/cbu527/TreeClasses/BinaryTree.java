package com.cbu527.TreeClasses;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BinaryTree<T> implements BFSInterface<T>{

    private TreeNode<T> root;
    private ArrayList<MainInterface> strategies;



    public boolean add(T pItem) {
        this.root = insertion(this.root,pItem);
        return true;
    }

    public boolean remove(T pItem) {
        if(contains(pItem)) {
            deleteNode(this.root, pItem);
            return true;
        }
        else
            return false;
    }


    public boolean contains(T pItem) {
        return searchTree(this.root,pItem);
    }


    public int numItems() {
        return count(this.root);
    }
    //returns the height of the tree
    public int height() {
        return calculateHeight(this.root);
    }


    public void print() {

        strategies = new ArrayList<MainInterface>();
        strategies.add(new PrintTree());
       // strategies.add(new BinarySearchTreeStrategy());
        strategies.add(new DepthSearchTreeStrategy());
        strategies.add(new MaximumDept());
        strategies.add(new MinimumDept());

        for (MainInterface s:strategies){
            s.print(this.root);
        }
    }


    private TreeNode<T> insertion (TreeNode<T> pCurrent, T pItem){
        //when node is empty
        if(pCurrent==null)
            return new TreeNode<T>(pItem);
            //decides where to put the value based on node's current value
        else if((Integer)pCurrent.getItem()>(Integer) pItem)
            pCurrent.setLeft(insertion(pCurrent.getLeft(),pItem));
        else if ((Integer)pCurrent.getItem()<(Integer) pItem)
            pCurrent.setRight(insertion(pCurrent.getRight(),pItem));
        return pCurrent;
    }


    private TreeNode<T> deleteNode (TreeNode<T> pCurrent, T pItem){
        //when node is empty
        if(pCurrent==null)
            return null;
        //item to be deleted is found
        if(pCurrent.getItem()==pItem){
            //if there are no children for this node
            if(pCurrent.getLeft()==null&&pCurrent.getRight()==null)
                return null;

            if(pCurrent.getRight()==null)
                return pCurrent.getLeft();

            if(pCurrent.getLeft()==null)
                return pCurrent.getRight();

            T smallestItem = findSmallestItem(pCurrent.getRight());
            pCurrent.setItem(smallestItem);
            pCurrent.setRight(deleteNode(pCurrent.getRight(),smallestItem));
            return pCurrent;

        } else if((Integer)pCurrent.getItem()>(Integer)pItem)
            pCurrent.setLeft(deleteNode(pCurrent.getLeft(),pItem));
        else if ((Integer)pCurrent.getItem() < (Integer)pItem)
            pCurrent.setRight(deleteNode(pCurrent.getRight(),pItem));
        return pCurrent;
    }

    private T findSmallestItem (TreeNode<T> pNode){
        if(pNode.getLeft()==null)
            return pNode.getItem();
        else
            return findSmallestItem(pNode.getLeft());
    }


    private boolean searchTree (TreeNode<T> pCurrent, T pItem){
        if(pCurrent==null)
            return false;
        else if(pCurrent.getItem()==pItem)
            return true;
        else{
            if((Integer)pCurrent.getItem()>(Integer) pItem)
                return searchTree(pCurrent.getLeft(),pItem);
            else
                return searchTree(pCurrent.getRight(),pItem);
        }
    }

    private int count (TreeNode<T> pCurrent) {
        if(pCurrent==null)
            return 0;
        else{
            int count = 1;
            count += count(pCurrent.getLeft());
            count += count(pCurrent.getRight());
            return count;
        }
    }

    private int calculateHeight(TreeNode<T> pCurrent){
        if(pCurrent==null)
            return 0;
        else{
            int left = calculateHeight(pCurrent.getLeft());
            int right = calculateHeight(pCurrent.getRight());
            return Math.max(left, right) + 1;

        }
    }

    private String whatToPrint(TreeNode<T> pCurrent){
        if(pCurrent==null)
            return "Null";
        else{
            return String.valueOf(pCurrent.getItem())+"("+whatToPrint(pCurrent.getLeft())+","+whatToPrint(pCurrent.getRight())+")";
        }
    }

    public void BFS() {
        //uses a queue to know which item to print
        System.out.print("BFS: ");
        Queue<TreeNode<T>> queue= new ConcurrentLinkedQueue<TreeNode<T>>();
        queue.add(root);
        while (queue.size()>0)
        {

            TreeNode<T> tempNode = queue.poll();
            System.out.print(tempNode.getItem() + " ");

            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }


        }
        System.out.println("");

    }


    public  void DFS(){

        if(root == null)
            return;
        System.out.print("DFS: ");
        Stack<TreeNode<T>> res = new Stack<TreeNode<T>>();
        res.add(root);
        while(res.size()>0){
            TreeNode<T> top = res.pop();
            System.out.print(top.getItem() + " ");
            if(top.getLeft()!=null)
                res.add(top.getLeft());
            if(top.getRight()!=null)
                res.add(top.getRight());

        }
        System.out.println("");

    }
    public TreeNode<T> getRoot(){
        return this.root;
    }
}
