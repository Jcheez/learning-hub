package leetcode.java;

// Time complexity: O(logN), where N is the number
// Space complexity: O(1)

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x;
        int length = 0;
        int timesToDivide = 0;
        int toCompare = 0;

        while (temp > 0) {
            length += 1;
            temp /= 10;
        }

        timesToDivide =  length / 2;

        for (int i=timesToDivide-1; i>=0; i--) {
            int lastDigit = x % 10;
            toCompare += lastDigit * Math.pow(10, i);
            x /= 10;
        }

        if (length % 2 != 0) {
            x /= 10;
        }

        return x == toCompare;
    }
}