package com.example.demo_practise.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: M_LCP003_CheckRobot
 * Description:
 * date: 2022/7/15 15:56
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LCP003_CheckRobot {

    /**
     * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
     *
     * U: 向y轴正方向移动一格
     * R: 向x轴正方向移动一格。
     * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
     *
     * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
     *
     * 示例 1：
     *
     * 输入：command = "URR", obstacles = [], x = 3, y = 2
     * 输出：true
     * 解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
     * 示例 2：
     *
     * 输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
     * 输出：false
     * 解释：机器人在到达终点前会碰到(2, 2)的障碍物。
     * 示例 3：
     *
     * 输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
     * 输出：true
     * 解释：到达终点后，再碰到障碍物也不影响返回结果。
     */
    public boolean robot(String command, int[][] obstacles, int x, int y) {

        int sx = 0;
        int sy = 0;
        for (int i = 0; i < command.length(); i++) {
            if(command.charAt(i) == 'U') {
                sy++;
                continue;
            }
            sx++;
        }
        int xMax[] = obstacles[0];
        int yMax[] = obstacles[0];

        HashMap<Integer, List<Integer>> xMap = new HashMap<>();
        for (int i = 0; i < obstacles.length; i++) {
            List<Integer> xlist = xMap.getOrDefault(obstacles[i][0], new ArrayList<>());
            xlist.add(obstacles[i][1]);
            xMap.put(obstacles[i][0], xlist);
            if(obstacles[i][0] > xMax[0]) {
                xMax = obstacles[i];
            }
            if(obstacles[i][1] > yMax[1]) {
                yMax = obstacles[i];
            }
        }



        int rx = 0, ry = 0;
        int count = 0;
        int commonLength = command.length();
        while (rx != x || ry != y) {
            count++;
            if(command.charAt(count % commonLength) == 'U') {
                ry++;
            } else {
                rx++;
            }
            if(rx > x || ry > y || xMap.getOrDefault(rx, new ArrayList<>()).contains(ry)) {
                return false;
            }
        }
        return true;
    }

    public boolean robot2(String command, int[][] obstacles, int x, int y) {
        int sx = 0;
        int sy = 0;
        HashMap<Integer, List<Integer>> trackMap = new HashMap<>();
        trackMap.put(0, new ArrayList<>(Arrays.asList(0)));
        for (int i = 0; i < command.length(); i++) {
            if(command.charAt(i) == 'U') {
                sy++;
            } else {
                sx++;
            }
            List<Integer> xlist = trackMap.getOrDefault(sx, new ArrayList<>());
            xlist.add(sy);
            trackMap.put(sx, xlist);
        }
        if((sx == 0 && x > 0) || (sy == 0 && y > 0)) {
            return false;
        }
        for (int i = 0; i < obstacles.length; i++) {
            int oTempx = obstacles[i][0];
            int oTempy = obstacles[i][1];
            if((sx == 0 && oTempx > 0) || (sy == 0 && oTempy > 0) || oTempx > x || oTempy > y) {
                continue;
            }
            int modx = oTempx / sx;
            int mody = oTempy / sy;
            oTempx = oTempx - sx * Math.min(modx, mody);
            oTempy = oTempy - sy * Math.min(modx, mody);
            List<Integer> yTemp = trackMap.getOrDefault(oTempx, new ArrayList<>());
            if(yTemp.contains(oTempy)) {
                return false;
            }
        }
        int modx = 0;
        int mody = 0;
        if(sx != 0) {
            modx = x / sx;
        }
        if(sy != 0) {
            mody = y / sy;
        }
        x = x - sx * Math.min(modx, mody);
        y = y - sy * Math.min(modx, mody);
        List<Integer> yTemp = trackMap.getOrDefault(x, new ArrayList<>());
        return yTemp.contains(y);
    }

    public static void main(String[] args) {
//        int arr[][] = new int[][]{{7, 7}, {0, 5}, {2, 7}, {8, 6}, {8, 7}, {6, 5}, {4, 4}, {0, 3}, {3, 6}};
//        System.out.println(new M_LCP003_CheckRobot().robot2("URRURRR",arr, 4915, 1966));
        int ar3r[][] = new int[][]{{4,2}};
        System.out.println(new M_LCP003_CheckRobot().robot2("URR",ar3r, 3, 2));
    }

}
