# Time complexity: O(logN), where N is the number
# Space complexity: O(1)

class Solution(object):
    def isPalindrome(self, x):
        original = x
        
        if x < 0:
            return False

        num_length = 0
        temp = x

        while temp > 0:
            temp = temp // 10
            num_length += 1

        temp = x
        flipped = 0
        while (num_length > 0):
            val = x % 10
            x = x / 10
            flipped += (val * (10**(num_length - 1)))
            num_length -= 1
        
        return flipped == original