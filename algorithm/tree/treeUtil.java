package com.example.demo_practise.algorithm.tree;

/**
 * ClassName: treeUtil
 * Description:
 * date: 2022/7/18 11:00
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class treeUtil {
    public static TreeNode tree = buildTree(null);

    public static TreeNode buildTree(int vals[]) {
        if(vals != null && vals.length == 0) {
            vals = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        }
        return null;
    }

    public static TreeNode buildTree94(int vals[]) {
        if(vals != null && vals.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(vals[0]);
//        buildTree();
        return null;
    }
}
