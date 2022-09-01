package com.example.demo_practise.algorithm.LCHOT100;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: S_LC001_GetTwoNumSum
 * Description: 两数之和
 * date: 2022/7/11 16:51
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class S_LC001_GetTwoNumSum {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> keyIndex = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(keyIndex.get(nums[i]) == null) {
                keyIndex.put(target - nums[i], i);
            } else {
                res[0] = keyIndex.get(nums[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static int[] resolveByDynamic(int[] nums, int target) {

        Map<Integer, Integer> keyIndex = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(keyIndex.get(nums[i]) == null) {
                keyIndex.put(target - nums[i], i);
            } else {
                res[0] = keyIndex.get(nums[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {3,2,4};
        int tar = 6;
        int sult[] = twoSum(arr, tar);
        System.out.println(sult[0] + "," + sult[1]);
    }

}
