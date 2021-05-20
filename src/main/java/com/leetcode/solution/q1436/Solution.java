package com.leetcode.solution.q1436;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for(List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        String start = paths.get(0).get(0);
        String destCityList = null;
        while ((destCityList = map.get(start)) != null){

            start = destCityList;
        }
        return start;
    }
}
