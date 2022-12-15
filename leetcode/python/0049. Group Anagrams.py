# Time complexity: O(NMlogM)
# Space complexity: O(NM)

class Solution(object):
    def groupAnagrams(self, strs):
        grouping = {}

        for s in strs:
            sorted_str = "".join(sorted(s))
            if sorted_str in grouping:
                grouping[sorted_str].append(s)
            else:
                grouping[sorted_str]= []
        
        return grouping.values()