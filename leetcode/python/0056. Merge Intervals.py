# Time complexity: O(NlogN)
# Space complexity: O(N)

class Solution(object):
    def merge(self, intervals):
        intervals.sort()
        res = []
        
        for start, end in intervals:
            if len(res) == 0:
                res.append([start, end])
            else:
                prev_start, prev_end = res[-1]

                if start <= prev_end:
                    res[-1][1] = max(prev_end, end)
                else:
                    res.append([start, end])
        return res