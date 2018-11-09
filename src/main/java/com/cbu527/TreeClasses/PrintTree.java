package com.cbu527.TreeClasses;

public class PrintTree implements MainInterface{

    public void print(TreeNode pRoot) {
        System.out.print("Model : Root(Left Leaf,Right Leaf)"+"\n");
        System.out.println(whatToPrint(pRoot));
    }
    private String whatToPrint(TreeNode pCurrent){
        if(pCurrent==null)
            return "Null";
        else{
            return String.valueOf(pCurrent.getItem())+"("+whatToPrint(pCurrent.getLeft())+","+whatToPrint(pCurrent.getRight())+")";
        }
    }
}
