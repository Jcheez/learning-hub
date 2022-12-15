# Time complexity: O(N)
# Space complexity: O(N)

class Solution(object):
    def longestPalindrome(self, s):

        freq = {}
        for char in s:
            if char in freq:
                freq[char] += 1
            else:
                freq[char] = 1
        
        odd = 0
        even = 0

        for al,count in freq.items():
            if count % 2 == 0:
                even += count
            else:
                if odd == 0:
                    odd = count
                elif odd > count:
                    even += count - 1
                else:
                    even += odd - 1
                    odd = count

        return odd + even