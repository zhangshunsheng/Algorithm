package com.example.demo_practise.algorithm.dynamic_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * ClassName: LC2289_SortTheArray
 * Description: todo 未解决
 * date: 2022/7/12 8:43
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class LC2289_SortTheArray {
    /**
     * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，移除所有满足 nums[i - 1] > nums[i] 的 nums[i] ，
     * 其中 0 < i < nums.length 。
     *
     * 重复执行步骤，直到 nums 变为 非递减 数组，返回所需执行的操作数。
     *
     * @param nums
     * @return
     */
    public static int totalSteps(int[] nums) {
        int count = 0;
        int countIndex = 0;
        // 比较的最大数下标
        int indexMax = 0;
        if(nums.length < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[indexMax]);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                /**
                 * 两种情况：nums[i-1]小于最大值、大于最大值
                 */
                count = Math.max(count, countIndex);
                countIndex = 1;
                indexMax = Math.max(indexMax, nums[i - 1]);
            } else if(nums[i] < indexMax) {
                countIndex++;
            } else {
                count = Math.max(count, countIndex);
                indexMax = nums[i];
                countIndex = 0;
            }
        }
        return Math.max(count, countIndex);
    }

    public static void main(String[] args) {
//        int arr[] = {10,1,2,3,4,5,6,1,2,3};
//        int arr[] = {4,5,7,7,13};
//        int arr[] = {5,3,4,4,7,3,6,11,8,5,11};
//        int arr[] = {7,14,4,14,13,2,6,13};
        int arr[] = {5,14,15,2,11,5,13,15};
        System.out.println(totalSteps(arr));
    }
}
