package leetcode.java;

// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int indexA = a.length() - 1;
        int indexB = b.length() - 1;

        int carry = 0;

        while (indexA >= 0 || indexB >= 0) {
            int currSum = carry;

            if (indexA >= 0) {
                currSum += (a.charAt(indexA) - '0');
                indexA -= 1;
            }

            if (indexB >= 0) {
                currSum += (b.charAt(indexB) - '0');
                indexB -= 1;
            }

            sb.insert(0, currSum % 2);
            carry = currSum / 2;
        }

        if (carry > 0) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}