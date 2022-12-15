package leetcode.java;

import java.util.HashMap;

// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int req = nums.length / 2;

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : map.keySet()) {
            if (map.get(num) > req) {
                return num;
            }
        }
        return -1;
    }
}