package com.cbu527.TreeClasses;

public class TreeNode<T> {

    private T item;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T pItem){
        this.item = pItem;
        this.left = null;
        this.right = null;
    }

    public void setItem(T item) {
        this.item = item;
    }
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T getItem() {
        return this.item;
    }

    public TreeNode<T> getLeft() {
        return this.left;
    }

    public TreeNode<T> getRight() {
        return this.right;
    }
}
