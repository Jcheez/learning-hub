package leetcode.java;

import java.util.HashMap;

// Time complexity: O(s), where s is the length of the string
// Space complexity: O(1)

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> symsToVals = initializeMeanings();
        int res = 0;
        
        for (int i=0; i<s.length(); i++) {

            if (i < s.length() - 1 && s.charAt(i) == 'I' && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) {
                res -= symsToVals.get(s.charAt(i));
            } else if ( i < s.length() - 1 && s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) {
                res -= symsToVals.get(s.charAt(i));
            } else if (i < s.length() - 1 && s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
                res -= symsToVals.get(s.charAt(i));
            } else {
                res += symsToVals.get(s.charAt(i));
            }
        }
        return res;
    }

    public HashMap<Character, Integer> initializeMeanings() {
        char[] symbols = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] values = new int[]{1, 5, 10, 50, 100, 500, 1000};

        HashMap<Character, Integer> res = new HashMap<>();

        for (int i=0; i<symbols.length; i++) {
            res.put(symbols[i], values[i]);
        }
        
        return res;
    }
}