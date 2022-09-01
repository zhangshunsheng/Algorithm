package com.example.demo_practise.algorithm.LCHOT100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: M_LC056_MergeInterval
 * Description:
 * date: 2022/7/15 9:05
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC056_MergeInterval {
    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
//        Arrays.sort(intervals, new Comparator<int[]>() {
////            @Override
////            public int compare(int[] o1, int[] o2) {
////                return o1[0] - o2[0];
////            }
////        });

//        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        quickSortArr(intervals, 0, intervals.length - 1);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            queue.add(intervals[i][0]);
            queue.add(intervals[i][1]);
        }
        Queue<Integer> resQueue = new LinkedList<>();
        int compareNum = 0;
        if(!queue.isEmpty()) {
            compareNum = queue.poll();
            resQueue.add(compareNum);
        }
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if(num > compareNum) {
                if (queue.size() % 2 != 0) {
                    resQueue.add(compareNum);
                    resQueue.add(num);
                }
                compareNum = num;
            }
        }
        resQueue.add(compareNum);
        int[][] resArr = new int[resQueue.size() / 2][2];
        int count = 0;
        while (!resQueue.isEmpty()) {
            resArr[count][0] = resQueue.poll();
            resArr[count][1] = resQueue.poll();
            count++;
        }
        return resArr;
    }

    public void quickSortArr(int[][] array, int start, int end){
        if(start >= end) {
            return;
        }
        int[] compare = array[start];
        int base = start;
        int finalIn = end;
        while (base < finalIn) {
            if(array[finalIn][0] < compare[0]){
                array[base] = array[finalIn];
                array[finalIn] = array[++base];
            } else {
                finalIn--;
            }
        }
        array[base] = compare;
        quickSortArr(array, start, base);
        quickSortArr(array, base + 1, end);
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{{8,12},{1,3},{2,6},{8,10},{15,18}};
        System.out.println(new M_LC056_MergeInterval().merge(arr));
    }

}
