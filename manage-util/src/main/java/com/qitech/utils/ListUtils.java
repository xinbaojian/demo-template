package com.qitech.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xin.bj
 * @program security-parent
 * @description 集合辅助类
 * @create 2019-02-26 08:22
 **/
public class ListUtils {

    public static Set<String> getDuplicateStrings(List<String> loginNameList) {
        Set<String> duplicateSet = new HashSet<>();
        String temp;
        for (int i = 0; i < loginNameList.size() - 1; i++) {
            temp = loginNameList.get(i);
            for (int j = i + 1; j < loginNameList.size(); j++) {
                if (temp.equals(loginNameList.get(j))) {
                    duplicateSet.add(temp);
                }
            }
        }
        return duplicateSet;
    }
}
