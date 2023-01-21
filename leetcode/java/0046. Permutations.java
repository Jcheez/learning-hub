package leetcode.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time complexity: O(N!), where N is the size of nums
// Space complexity: O(N)

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums.length == 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[0]);
            res.add(temp);
            return res;
        }

        Queue<Integer> temp = new LinkedList<>();
        
        for (int num : nums) {
            temp.add(num);
        }

        int counter = nums.length;
        
        while (counter > 0) {
            int pulled = temp.poll();
            List<List<Integer>> subPermutations = this.permute(temp.stream().mapToInt(Integer::intValue).toArray());

            for (List<Integer> perm : subPermutations) {
                perm.add(pulled);
                res.add(perm);
            }

            temp.add(pulled);
            counter -= 1;
        }

        return res;
    }
}