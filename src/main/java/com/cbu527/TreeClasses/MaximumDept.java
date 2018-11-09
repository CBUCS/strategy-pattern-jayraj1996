package com.cbu527.TreeClasses;

public class MaximumDept implements MainInterface {
    public void print(TreeNode pRoot) {

        System.out.println("Maximum Depth: "+calculateHeight(pRoot));
    }
    private int calculateHeight(TreeNode pCurrent){
        if(pCurrent==null)
            return 0;
        else{
            int left = calculateHeight(pCurrent.getLeft());
            int right = calculateHeight(pCurrent.getRight());
            return Math.max(left, right) + 1;

        }
    }
}
