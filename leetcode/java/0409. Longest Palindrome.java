package leetcode.java;

import java.util.HashMap;

// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        int odd = 0;
        int even = 0;

        for (char c2 : map.keySet()) {
            if (map.get(c2) % 2 == 0) {
                even += map.get(c2);
            } else {
                if (odd > 1) {
                    even += odd - 1;
                }
                odd = Integer.max(odd, map.get(c2));
            }
        }
        return odd + even;
    }
}