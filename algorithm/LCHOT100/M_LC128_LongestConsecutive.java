package com.example.demo_practise.algorithm.LCHOT100;

import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: M_LC128_LongestConsecutive
 * Description:
 * date: 2022/7/14 17:01
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC128_LongestConsecutive {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     */
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        if(nums.length < 1) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null) {
                int left = map.get(nums[i] - 1) == null ? 0 : map.get(nums[i] - 1);
                int right = map.get(nums[i] + 1) == null ? 0 : map.get(nums[i] + 1);
                int num = left + right + 1;
                res = Math.max(res, num);
                map.put(nums[i], num);
                if (left > 0) {
                    map.put(nums[i] - left, num);
                }
                if (right > 0) {
                    map.put(nums[i] + right, num);
                }
            }
        }
        return res;
    }

    /**
     * 遍历，但是只从连续序列的第一个数字开始遍历
     * @param nums
     * @return
     */
    public int longestConsecutiveTwo(int[] nums) {
        int res = 0;
        if(nums.length < 1) {
            return res;
        }
        Set<Integer> setData = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            setData.add(nums[i]);
        }

        for(int num : setData) {
            if(!setData.contains(num - 1)) {
                int count = 0;
                int start = num;
                while (setData.contains(start)) {
                    count++;
                    start++;
                }
                res = Math.max(res, count);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temp = new int[]{100,4,200,1,3,2,0,3,7,2,5,8,4,6,0,1};
        System.out.println(new M_LC128_LongestConsecutive().longestConsecutive(temp));
    }
}
