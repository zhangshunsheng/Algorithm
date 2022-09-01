package com.example.demo_practise.algorithm.LCHOT100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: M_LC015_ThreeNumSum
 * Description:
 * date: 2022/7/13 14:12
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC015_ThreeNumSum {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3) {
            return res;
        }
//        Arrays.sort(nums);
        quickSort(nums, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    res.add(temp);
                    start++;
                    end--;
                    while(nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if(sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return res;
    }

    public void quickSort(int[] nums, int start, int end) {
        if(start >= end) {
            return ;
        }
        int compareNum = nums[start];
        int base = start;
        int finalIn = end;
        while (finalIn > base) {
            if(nums[finalIn] < compareNum) {
                nums[base] = nums[finalIn];
                nums[finalIn] = nums[++base];
            } else {
                finalIn--;
            }
        }
        nums[base] = compareNum;
        quickSort(nums, start, base);
        quickSort(nums, base + 1, end);
    }

    public static void main(String[] args) {

    }
}
