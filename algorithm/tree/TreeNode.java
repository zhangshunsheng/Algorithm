package com.example.demo_practise.algorithm.tree;

import lombok.Data;

/**
 * ClassName: TreeNode
 * Description: 二叉树节点.
 * date: 2022/7/18 10:53
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
@Data
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    TreeNode () {}
    public TreeNode (int val) {
        this.val = val;
    }
    public TreeNode (int val, TreeNode left) {
        this.val = val;
        this.left = left;
    }
    public TreeNode (int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
