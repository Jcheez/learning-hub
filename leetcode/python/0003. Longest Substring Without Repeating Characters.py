# Time complexity: O(N) N refers to the length of the input string
# Time complexity: O(M) M refers to the length of the longest substring

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        if len(s) == 0:
            return 0
        elif len(s) == 1:
            return 1
        
        maxLength = 0
        left = 0
        right = 0
        
        storage = set()
        storage.add(s[left])

        while right < len(s)-1:
            right += 1
            while s[right] in storage:
                storage.remove(s[left])
                left += 1
            storage.add(s[right])
            maxLength = max(maxLength, right-left+1)
        return maxLength