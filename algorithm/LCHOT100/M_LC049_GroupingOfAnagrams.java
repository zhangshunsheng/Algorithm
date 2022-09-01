package com.example.demo_practise.algorithm.LCHOT100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: M_LC049_GroupingOfAnagrams
 * Description: 字母异位词分组.
 * date: 2022/7/18 15:02
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC049_GroupingOfAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> resMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] strArr = strs[i].toCharArray();
            Arrays.sort(strArr);
            String newStr = new String(strArr);
            if(resMap.get(newStr) == null) {
                resMap.put(newStr, new ArrayList<String>(strArr[i]));
            } else {
                resMap.get(newStr).add(strs[i]);
            }
        }

        return new ArrayList<>(resMap.values());
    }

}
