# Time complexity: O(N)
# Space complexity: O(1)

class Solution(object):
    def characterReplacement(self, s, k):
        freq_table = {}

        left = 0
        right = 0
        res = 0

        freq_table[s[left]] = 1

        while right < len(s)-1:
            right += 1
            if s[right] in freq_table:
                freq_table[s[right]] += 1
            else:
                freq_table[s[right]] = 1
            
            if right-left+1 - self.most_frequent(freq_table) > k:
                freq_table[s[left]] -= 1
                left += 1
            res = max(res, right-left+1)  
        return res          

            
    def most_frequent(self, freq_table):
        return max(freq_table.values())