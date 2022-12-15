# Time complexity: O(NlogN)
# Space complexity: O(1)

class Solution(object):
    def eraseOverlapIntervals(self, intervals):
        
        intervals.sort(lambda x: x[0])
        changes = 0
        prev = intervals[0][1]

        for start, end in intervals[1:]:
            if start >= prev:
                prev = end
            else:
                changes += 1
                prev = min(prev, end)
        return changes