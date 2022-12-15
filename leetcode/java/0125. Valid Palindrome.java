package leetcode.java;

// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        int left = 0;
        int right = sb.length() - 1;

        while (right >= left) {
            if (sb.charAt(right) == sb.charAt(left)) {
                left += 1;
                right -= 1;
            } else {
                return false;
            }
        }
        return true;
    }
}