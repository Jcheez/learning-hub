package leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

// Time complexity: O(NMlogM)
// Space complexity: O(NM)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            String toSort = word;
            char[] charToSort = toSort.toCharArray();
            Arrays.sort(charToSort);

            toSort = new String(charToSort);

            if (map.containsKey(toSort)) {
                List<String> chars = map.get(toSort);
                chars.add(word);
                map.put(toSort, chars);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(word);
                map.put(toSort, newList);
            }
        }

        return map.values().stream().collect(Collectors.toList());
    }
}