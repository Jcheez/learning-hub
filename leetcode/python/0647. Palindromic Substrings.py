# Time complexity: O(N^2)
# Space complexity: O(1)

class Solution(object):
    def countSubstrings(self, s):
        res = 0

        for i in range(len(s)):
            
            left = i
            right = i
            while left>=0 and right<len(s) and s[left] == s[right]:
                left -= 1
                right += 1
                res += 1
            
            left = i
            right = i+1
            while left>=0 and right<len(s) and s[left] == s[right]:
                left -= 1
                right += 1
                res += 1

        return res        