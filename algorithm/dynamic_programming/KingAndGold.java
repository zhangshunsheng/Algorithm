package com.example.demo_practise.algorithm.dynamic_programming;

/**
 * ClassName: KingAndGold
 * Description: 国王与金矿
 * date: 2022/7/11 10:48
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class KingAndGold {
    /**
     * 题目：
     * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。
     * 参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
     * 要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
     * 金矿规格：500金/5人、200金/3人、300金/4人、300金/3人、400金/5人
     */

    /**
     * 求解思路
     * @param gold 金矿规格
     * @param worker 金矿对应所需工人数量
     * @param num 挖矿工人总数
     * @return 能获得的最大金子数
     */
    public static int getMostGold(int gold[], int worker[], int num) {
            int goldAndWorker[][] = new int[gold.length][num + 1];
            for(int g = 0; g < goldAndWorker.length; g++) {
                for(int w = 0; w <= num; w++) {
                    if(w < worker[g]) {
                        goldAndWorker[g][w] = 0;
                    } else if(g > 0) {
                        goldAndWorker[g][w] = Math.max(goldAndWorker[g - 1][w], goldAndWorker[g - 1][w - worker[g]] + gold[g]);
                    } else {
                        goldAndWorker[g][w] = gold[g];
                    }
                }
            }
            return goldAndWorker[gold.length - 1][num];
    }

    public static void main(String[] args) {
        int[] gold = {400, 500, 200, 300, 350};
        int[] worker = {5, 5, 3, 4, 3};
        System.out.println(getMostGold(gold, worker, 10));
    }

}
