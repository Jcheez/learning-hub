# Time complexity: O(logN)
# Space complexity: O(1)

class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        numOneBits = 0

        for i in range(32):
            if (n & 1) == 1:
                numOneBits += 1

            n >>=1
        return numOneBits