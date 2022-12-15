package leetcode.java;

import java.util.HashMap;
import java.util.PriorityQueue;

// Time complexity: O(NlogK)
// Space complexity: O(N + k)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        System.out.println(map.toString());

        PriorityQueue<Integer> minheap = new PriorityQueue<>(
            (o1, o2) -> map.get(o1) - map.get(o2)
        );
        for (int n2 : map.keySet()) {
            minheap.add(n2);
            System.out.println(n2);

            if (minheap.size() > k) {
                minheap.poll();
            }
        }

        System.out.println(minheap);


        int[] res = new int[k];
        for (int i=0; i<k; i++) {
            res[i] = minheap.poll();
        }

        return res;
    }
}