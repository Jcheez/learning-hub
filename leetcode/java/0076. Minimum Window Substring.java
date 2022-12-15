package leetcode.java;

// Time complexity: O(N)
// Space complexity: O(1)

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> required = new HashMap<>();

        for (char c : t.toCharArray()) {
            if (required.containsKey(c)) {
                required.put(c, required.get(c) + 1);
            } else {
                required.put(c, 1);
            }
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int subStart = 0;
        int subEnd = 0;
        int minLength = 999999;
        int numMatches = 0;

        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            } else {
                map.put(s.charAt(right), 1);
            }

            if (required.containsKey(s.charAt(right)) && required.get(s.charAt(right)).intValue() == map.get(s.charAt(right)).intValue()) {
                numMatches += 1;
            }

            while (numMatches == required.size()) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (required.containsKey(s.charAt(left)) && required.get(s.charAt(left)) > map.get(s.charAt(left))) {
                    numMatches -= 1;
                }

                if (right - left + 1 < minLength) {
                    subStart = left;
                    subEnd = right;
                    minLength = right - left + 1;
                }
                left += 1;
            }
            right += 1;
        }
        return minLength == 999999 ? "" : s.substring(subStart, subEnd+1);
    }
}