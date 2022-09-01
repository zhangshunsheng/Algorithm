package com.example.demo_practise.algorithm.LCHOT100;

import java.util.LinkedList;
import java.util.Stack;

/**
 * ClassName: H_LC084_GetTheMaxRectangleArea
 * Description: todo 未解决
 * date: 2022/7/18 15:41
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class H_LC084_GetTheMaxRectangleArea {
    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * 超时
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     */

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int leftIndex = i;
            int rightIndex = heights.length - 1;
            for (int j = i - 1; j >= 0 ; j--) {
                if (heights[j] < heights[i]) {
                    leftIndex = j + 1;
                    break;
                } else {
                    leftIndex = j;
                }
            }
            for (int j = i + 1; j < heights.length ; j++) {
                if (heights[j] < heights[i]) {
                    rightIndex = j - 1;
                    break;
                } else {
                    rightIndex = j;
                }
            }
            maxArea = Math.max(maxArea, (rightIndex - leftIndex + 1) * heights[i]);
        }
        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        if(heights.length == 0) {
            return maxArea;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if(stack.size() > 0 && heights[i] < heights[stack.peek()]) {
                while (!stack.empty() && heights[i] < heights[stack.peek()]) {
                    int index = stack.pop();
                    int left = -1;
                    if(!stack.empty()) {
                        left = stack.peek();
                    }
                    maxArea = Math.max(maxArea, heights[index] * (i - left - 1));
                }
            }
            stack.push(i);
        }
        int compareIndex = stack.peek();
        while (!stack.empty()) {
            int index = stack.pop();
            int leftIndex = stack.empty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, heights[index] * (compareIndex - leftIndex));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] area = new int[]{2,1,2};
        System.out.println(
                new H_LC084_GetTheMaxRectangleArea().largestRectangleArea2(area)
        );
    }
}
