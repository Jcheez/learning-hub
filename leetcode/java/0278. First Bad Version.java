package leetcode.java;

// Ficticious class to bypass highlighted errors
class VersionControl {
    public boolean isBadVersion(int version) {
        return true;
    }
}

// Time complexity: O(logN)
// Space complexity: O(1)

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (right > left) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}