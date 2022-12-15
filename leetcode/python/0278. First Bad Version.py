# Time complexity: O(logN)
# Space complexity: O(1)

def isBadVersion():
    '''
    Question has predefined this function
    '''
    pass

class Solution(object):
    def firstBadVersion(self, n):

        if isBadVersion(1):
            return 1

        left = 1
        right = n - 1

        while right >= left:
            mid = (left + right) / 2

            if isBadVersion(mid):
                right = mid - 1
            else:
                left = mid + 1
        return left