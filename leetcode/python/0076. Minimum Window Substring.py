# Time complexity: O(N)
# Space complexity: O(1)

class Solution(object):
    def minWindow(self, s, t):
        freq_t = {}
        for char in t:
            if char in freq_t:
                freq_t[char] += 1
            else:
                freq_t[char] = 1
        
        freq_s = {}
        start = 0
        end = 0
        left = 0
        length = 999999
        need = 0

        for right in range(len(s)):
            ch = s[right]
            if ch in freq_s:
                freq_s[ch] += 1
            else:
                freq_s[ch] = 1

            if ch in freq_t and freq_t[ch] == freq_s[ch]:
                need += 1
            
            while need == len(freq_t):
                if right-left+1 < length:
                    start = left
                    end = right
                    length = end-start+1
                
                c = s[left]
                freq_s[c] -= 1
                if c in freq_t and freq_t[c] > freq_s[c]:
                    need -= 1
                left += 1
        
        return s[start:end+1] if length != 999999 else ""