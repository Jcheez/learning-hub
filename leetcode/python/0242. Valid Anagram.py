# Time complexity: O(N)
# Space complexity: O(1)

class Solution(object):
    def isAnagram(self, s, t):
        freq = {}

        # Building the frequency table
        for c in s:
            if c in freq:
                freq[c] += 1
            else:
                freq[c] = 1
        
        # Matching t with the frequency table. Table should be empty at the end
        for char in t:
            if char in freq:
                freq[char] -= 1
                if freq[char] == 0:
                    del freq[char]
            else:
                return False
        return len(freq) == 0
        