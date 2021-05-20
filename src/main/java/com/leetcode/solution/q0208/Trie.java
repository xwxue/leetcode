package com.leetcode.solution.q0208;


public class Trie {
    private class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
    }

    final Node first;

    /** Initialize your data structure here. */
    public Trie() {
        first = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = first;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            Node child = node.children[index];
            if(child == null) {
                child = new Node();
                node.children[index] = child;
            }
            node = child;
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = searchNode(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private Node searchNode(String prefix) {
        Node node = first;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            Node child = node.children[index];
            if(child == null) {
                return null;
            }
            node = child;
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("world");
        System.out.println(trie.search("w"));
        System.out.println(trie.startsWith("w"));
        System.out.println(trie.search("world"));
        System.out.println(trie.startsWith("wc"));
    }
}
