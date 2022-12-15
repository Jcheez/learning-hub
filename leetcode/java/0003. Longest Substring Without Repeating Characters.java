package leetcode.java;

// Time complexity: O(N) N refers to the length of the input string
// Time complexity: O(M) M refers to the length of the longest substring

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> map = new HashSet<>();

        int left = 0;
        int right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            if (map.contains(s.charAt(right))) {
                while (map.contains(s.charAt(right))) {
                    map.remove(s.charAt(left));
                    left += 1;
                }
            }
            map.add(s.charAt(right));
            maxLength = Integer.max(right - left + 1, maxLength);
            right += 1;
        }
        return maxLength;
    }
}