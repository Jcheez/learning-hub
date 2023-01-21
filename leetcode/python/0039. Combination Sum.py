# Time complexity: O(2^T), where T is the target value
# Space complexity: O(T), where T is the target value

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        self.helper(0, candidates, target, [], res)
        return res
    
    def helper(self, currIndex, candidates, targetLeft, currList, res):
        if currIndex < len(candidates) and targetLeft > 0:
            self.helper(currIndex, candidates, targetLeft - candidates[currIndex], currList+[candidates[currIndex]], res)
            self.helper(currIndex+1, candidates, targetLeft, currList, res)
        elif targetLeft == 0:
            res.append(currList)
        
