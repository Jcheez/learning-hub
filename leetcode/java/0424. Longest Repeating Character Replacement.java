package leetcode.java;

// Time complexity: O(N)
// Space complexity: O(1)

class Solution {
    public int characterReplacement(String s, int k) {
        int[] characterMap = new int[26];

        int left = 0;
        int right = 0;
        int longestSub = 0;

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            characterMap[(int) currentChar - (int) 'A'] += 1;

            int mostFreq = this.findMostFreq(characterMap);
            int numProcessed = right - left + 1;
            if (numProcessed - mostFreq <= k) {
                longestSub = Integer.max(numProcessed, longestSub);
            } else {
                characterMap[(int) s.charAt(left) - (int) 'A'] -= 1;
                left += 1;
            }
            right += 1;
        }
        return longestSub;
    }

    public int findMostFreq(int[] arr) {
        int mostFreq = 0;

        for (int num : arr) {
            if (num > mostFreq) {
                mostFreq = num;
            }
        }
        return mostFreq;
    }
}