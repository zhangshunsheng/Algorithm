package com.example.demo_practise.algorithm.LCHOT100;

/**
 * ClassName: M_LC033_FindDataIndex
 * Description:
 * date: 2022/7/29 15:38
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC033_FindDataIndex {
    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     *
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     *
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     *
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * 示例 2：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     *
     * 输入：nums = [1], target = 0
     * 输出：-1
     */

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        return getIndexByHalf(nums, target, 0, nums.length - 1);
    }

    public int getIndexByHalf(int[] nums, int target, int start, int end) {
        if(start >= end) {
            return nums[start] == target ? start : -1;
        }
        int mid = (start + end) >>> 1;
        if(nums[mid] == target) {
            return mid;
        }
        int compare = nums[mid];
        if(target > compare) {
            if(compare > nums[end] || (compare < nums[end] && nums[end] >= target)) {
                return getIndexByHalf(nums, target, mid + 1, end);
            }
            return getIndexByHalf(nums, target, start, mid - 1);
        }
        if(compare < nums[end] || (compare > nums[end] && nums[start] <= target)) {
            return getIndexByHalf(nums, target, start, mid - 1);
        }
        return getIndexByHalf(nums, target, mid + 1, end);
    }

    public static void main(String[] args) {
        int data[] = new int[]{5,1,2,3,4};
        System.out.println(new M_LC033_FindDataIndex().search(data, 1));
    }
}
