package leetcode.java;

import java.util.ArrayList;
import java.util.List;

// Time complexity: O(2^T), where T is the target value
// Space complexity: O(T), where T is the target value

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        this.helper(target, candidates, new ArrayList<>(), res, 0);
        return res;
    }

    public void helper(int target, int[] candidates, List<Integer> curr, List<List<Integer>> res, int pointer) {
        System.out.println(target);
        if (target > 0 && pointer < candidates.length) {
            List<Integer> temp = new ArrayList<>(curr);
            temp.add(candidates[pointer]);
            this.helper(target-candidates[pointer], candidates, temp, res, pointer);
            this.helper(target, candidates, curr, res, pointer+1);
        } else if (target == 0) {
            res.add(new ArrayList<>(curr));
        }
    }
}   