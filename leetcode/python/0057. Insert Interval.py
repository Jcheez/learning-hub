# Time complexity: O(N)
# Space complexity: O(N)

class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """

        res = []

        for idx in range(len(intervals)):
            start, end = intervals[idx]

            if start > newInterval[1]:
                res.append(newInterval)
                return res + intervals[idx:]
            elif end < newInterval[0]:
                res.append(intervals[idx])
            else:
                newInterval[0] = min(newInterval[0], start)
                newInterval[1] = max(newInterval[1], end)
        res.append(newInterval)
        return res