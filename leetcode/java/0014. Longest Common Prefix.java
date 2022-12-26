package leetcode.java;

import java.util.HashMap;

// Time complexity: O(S), where S is the total number of characters
// Space complexity: O(S), where S is the total number of characters

class TrieNode {
    public HashMap<Character, TrieNode> node;
    public int count;
    public int total;

    public TrieNode() {
        this.node = new HashMap<>();
        this.count = 0;
        this.total = 0;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        TrieNode map = new TrieNode();
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            TrieNode temp = map;
            for (char c : s.toCharArray()) {
                if (!temp.node.containsKey(c)) {
                    temp.node.put(c, new TrieNode());
                    temp.count += 1;
                }
                temp.total += 1;
                temp = temp.node.get(c);
            }
        }

        while (map.count == 1 && map.total == strs.length) {
            char key = map.node.entrySet().stream().findFirst().get().getKey();
            sb.append(key);
            map = map.node.get(key);
        }

        return sb.toString();
    }
}