package com.cbu527.Main;

import com.cbu527.TreeClasses.BinaryTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainTree {
    public static final Logger logger = LogManager.getLogger(MainTree.class);
    public static void main(String... args){
        BinaryTree<Integer>  tree = new BinaryTree<Integer>();
        tree.add(4);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        tree.add(2);
        tree.add(5);


        tree.print();
    }
}
