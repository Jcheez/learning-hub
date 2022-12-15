'''
Frequency table
Use a while loop to get the top occuring elements
'''
import heapq

# Time complexity: O(NlogK)
# Space complexity: O(N + k)

class Solution(object):
    def topKFrequent(self, nums, k):
        
        storage = {}
        for num in nums:
            if num in storage:
                storage[num] += 1
            else:
                storage[num] = 1
        
        return heapq.nlargest(k, storage.keys(), key=storage.get)