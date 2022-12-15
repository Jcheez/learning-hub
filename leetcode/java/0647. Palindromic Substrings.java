package leetcode.java;

// Time complexity: O(N^2)
// Space complexity: O(1)

class Solution {
    public int countSubstrings(String s) {
        int numPalindromes = 0;
        
        for (int i=0; i<s.length(); i++) {

            int left = i;
            int right = i;

            while (left >=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                numPalindromes += 1;
                left -= 1;
                right += 1;
            }

            left = i;
            right = i+1;

            while (left >=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                numPalindromes += 1;
                left -= 1;
                right += 1;
            }
        }
        return numPalindromes;
    }
}