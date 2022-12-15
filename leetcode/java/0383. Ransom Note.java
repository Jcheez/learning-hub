package leetcode.java;

import java.util.HashMap;

// Time complexity:O(N)
// Space complexity:O(N)

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c2 : ransomNote.toCharArray()) {
            if (map.containsKey(c2)) {
                map.put(c2, map.get(c2)-1);
                if (map.get(c2) == 0) {
                    map.remove(c2);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}