package com.example.demo_practise.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: M_LC006_ZStringChange
 * Description:
 * date: 2022/8/9 14:01
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC006_ZStringChange {
    public String convert(String s, int numRows) {
        String res = "";
        for(int i = 0; i < numRows; i++) {
            res += getPartString(s, i, numRows);
        }
        return res;
    }

    public String getPartString(String s, int index, int num) {
        String res = "";
        int length = s.length();
        int point = index;
        while(point < s.length()) {
            res += s.charAt(point);
            if(index == 0 || index == num - 1) {
                point += (num - 1) * 2;
                continue;
            }
            point += (num - index - 1) * 2;
            if(point < s.length()) {
                res += s.charAt(point);
                point += 2 * index;
            } else {
                break;
            }
        }
        return res;
    }

    public String convert2(String s, int numRows) {
        if(numRows < 2) {
            return s;
        }
        List<StringBuilder> stringList = new ArrayList<>();
        for(int i = 0; i < numRows; i++) stringList.add(new StringBuilder());
        int flag = -1;
        int index = 0;
        for(char c : s.toCharArray()) {
            stringList.get(index).append(c);
            if(index == 0 || index == numRows - 1) {
                flag = -flag;
            }
            index += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder temp : stringList) res.append(temp.toString());
        return res.toString();
    }

    public static void main(String[] args) {
        M_LC006_ZStringChange test = new M_LC006_ZStringChange();
        String s = "PAYPALISHIRING";
        System.out.println(test.convert2(s, 1));
    }
}
