package com.leetcode.solution.q1579;

import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufa = new UnionFind(n);
        UnionFind ufb = new UnionFind(n);

        for (int[] edge : edges) {
            edge[1]--;
            edge[2]--;
        }

        int res = 0;

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if(ufa.connected(edge[1], edge[2]) && ufb.connected(edge[1], edge[2])) {
                    res ++;
                } else {
                  ufa.union(edge[1], edge[2]);
                  ufb.union(edge[1], edge[2]);
                }

            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if(ufa.connected(edge[1], edge[2])) {
                    res ++;
                } else {
                    ufa.union(edge[1], edge[2]);
                }
            }
            if (edge[0] == 2) {
                if(ufb.connected(edge[1], edge[2])) {
                    res ++;
                } else {
                    ufb.union(edge[1], edge[2]);
                }
            }
        }
        if(ufa.setCount != 1 || ufb.setCount != 1) {
            return -1;
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\xuewei01\\Desktop\\input.txt"));

        int n = Integer.parseInt(reader.readLine());

        JSONArray edgeJsonArray = JSONArray.parseArray(reader.readLine());

        int[][] edges = new int[edgeJsonArray.size()][];

        for(int i = 0; i < edges.length; i++) {
            JSONArray edgeJson = edgeJsonArray.getJSONArray(i);
            int[] edge = new int[edgeJson.size()];
            for(int j = 0; j < edge.length; j++) {
                edge[j] = edgeJson.getInteger(j);
            }
            edges[i] = edge;
        }

        long start = System.currentTimeMillis();
        int result = solution.maxNumEdgesToRemove(n, edges);
        long time = System.currentTimeMillis() - start;


        System.out.println("result : " + result + "  time : " + time);
    }

}

// 并查集模板
class UnionFind {
    private final int[] roots;
    private final int[] size;
    public int setCount;

    public UnionFind(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        setCount = n;
        size = new int[n];
        Arrays.fill(size, 1);
    }

    private int findRoot(int i) {
        int j = i;
        while (j != roots[j]) {
            j = roots[j];
        }

        while (i != roots[i]) {
            int parent = roots[i];
            roots[i] = j;
            i = parent;
        }

        return j;
    }

    public boolean connected(int a, int b) {

        return findRoot(a) == findRoot(b);
    }

    public void union(int a, int b) {
        int aRoot = findRoot(a);
        int bRoot = findRoot(b);
        setCount--;
        if(size[a] < size[b]) {
            roots[aRoot] = bRoot;
            size[bRoot] += size[aRoot];
        } else {
            roots[bRoot] = aRoot;
            size[aRoot] += size[bRoot];
        }
    }

}
