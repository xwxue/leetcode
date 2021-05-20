package com.leetcode.solution.q1999;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> path = new LinkedList<>();
        path.add(beginWord);
        dfs(path, beginWord, endWord, wordList);
        if(path.size() == 1) {
            return Collections.emptyList();
        }
        return path;
    }

    private boolean dfs(LinkedList<String> path, String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) {
            return true;
        }
        if(!wordList.contains(endWord)) {
            return false;
        }
        List<String> oneDiffList = oneDiff(beginWord, wordList);

        if (oneDiffList.isEmpty()) {
            return false;
        }
        for (String nextWord : oneDiffList) {
            if(path.contains(nextWord)) {
                continue;
            }
            path.add(nextWord);
            wordList.remove(nextWord);
            if (dfs(path, nextWord, endWord, wordList)) {
                return true;
            } else {
                path.removeLast();
            }
        }
        return false;
    }

    private List<String> oneDiff(String word, List<String> wordList) {
        List<String> oneDiffWords = new ArrayList<>();
        for (String word2 : wordList) {
            if (word.length() != word2.length()) {
                continue;
            }
            int diff = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != word2.charAt(i)) {
                    diff++;
                }
                if (diff > 1) {
                    break;
                }
            }
            if (diff == 1) {
                oneDiffWords.add(word2);
            }
        }
        return oneDiffWords;
    }

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        String[] wordList = {"hot","cog","dog","tot","hog","hop","pot","dot"};
        System.out.println(new Solution().findLadders(beginWord, endWord, Arrays.stream(wordList).collect(Collectors.toList())));

    }

}
