package leetcode.java;

// Time complexity: O(logN)
// Space complexity: O(1)

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int numOnes = 0;

        while (n != 0) {
            numOnes += (n & 1);
            n = n >>> 1;
        }
        return numOnes;
    }
}