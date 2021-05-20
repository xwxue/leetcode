package com.leetcode.solution.q0208;

import java.util.HashSet;
import java.util.Set;

public class Trie1 {
    private Set<String> wordSet;
    private Set<String> trieSet;
    /** Initialize your data structure here. */
    public Trie1() {
        wordSet = new HashSet<>();
        trieSet = new HashSet<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        wordSet.add(word);
        int len = word.length();
        for (int i = 0; i < len; i++) {
            trieSet.add(word.substring(0, len - i));
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return wordSet.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return trieSet.contains(prefix);
    }

    public static void main(String[] args) {
        new Trie1().insert("world");
    }
}
