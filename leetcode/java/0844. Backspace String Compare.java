package leetcode.java;

// Time complexity: O(MAX(S, T)) where S is the length of s and T is the length of t
// Space complexity: O(S + T)

class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sbS = new StringBuilder();
        StringBuilder sbT = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (sbS.length() > 0) {
                    sbS.deleteCharAt(sbS.length() - 1);
                }
            } else {
                sbS.append(c);
            }
        }

        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (sbT.length() > 0) {
                    sbT.deleteCharAt(sbT.length() - 1);
                }
            } else {
                sbT.append(c);
            }
        }

        return sbS.toString().equals(sbT.toString());
    }
}