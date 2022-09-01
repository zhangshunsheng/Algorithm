package com.example.demo_practise.algorithm.leetcode;

import java.util.*;

/**
 * ClassName: S_LC1260_MoveData
 * Description:
 * date: 2022/7/20 15:03
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class S_LC1260_MoveData {
    /**
     * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
     *
     * 每次「迁移」操作将会引发下述活动：
     *
     * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
     * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
     * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
     * 请你返回 k 次迁移操作后最终得到的 二维网格。
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++)
                stack.push(grid[i][j]);
        }
        Queue<Integer> queue = new LinkedList<>();
        while(!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        for(int i = 0; i < k; i++) {
            queue.add(queue.poll());
        }
        while(!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        List<List<Integer>> res = new ArrayList<>(grid.length);
        int length = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int i1 = 0; i1 < length; i1++) {
                temp.add(stack.pop());
            }
            res.add(temp);
        }
        return res;
    }

    public List<List<Integer>> shiftGrid2(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            List temp = new ArrayList();
            for (int i1 = 0; i1 < n; i1++) {
                temp.add(0);
            }
            res.add(temp);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                int index = (i * n + i1 + k) % (m * n);
                res.get(index / n).set(index % n, grid[i][i1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int test[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new S_LC1260_MoveData().shiftGrid2(test, 1));
    }

}
