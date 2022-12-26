package leetcode.java;

// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i=1; i<=n; i++) {
            res[i] = this.countOnes(i, res);
        }
        return res;
    }

    public int countOnes(int dec, int[] memo) {
        int count = 0;
        while (dec > 0) {
            if (memo[dec] != 0) {
                return count + memo[dec];
            } 
            
            if (dec  % 2 != 0) {
                count += 1;
            }
            dec /= 2;
        }
        return count;
    }
}