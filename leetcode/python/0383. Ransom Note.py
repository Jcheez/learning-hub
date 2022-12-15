# Time complexity:O(N)
# Space complexity:O(N)

class Solution(object):
    def canConstruct(self, ransomNote, magazine):

        freq_m = {}
        for char in magazine:
            if char in freq_m:
                freq_m[char] += 1
            else:
                freq_m[char] = 1

        for char in ransomNote:
            if char not in freq_m:
                return False
            freq_m[char] -= 1
            if freq_m[char] == 0:
                del freq_m[char]

        return True