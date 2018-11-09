package com.cbu527.TreeClasses;

public class MinimumDept implements MainInterface{
    public void print(TreeNode Root) {
        System.out.println("Minimum Depth "+calculateHeight(Root));
    }

    private int calculateHeight(TreeNode Current){
        if(Current==null)
            return 0;
        else{
            int left = calculateHeight(Current.getLeft());
            int right = calculateHeight(Current.getRight());
            return Math.min(left, right) + 1;

        }
    }
}
