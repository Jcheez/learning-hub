# Time complexity: O(S), where S is the total number of characters
# Space complexity: O(S), where S is the total number of characters

class trie:

    def __init__(self):
        self.storage = {}
        self.next = None

class Solution(object):
    def longestCommonPrefix(self, strs):
        res = []
        store = trie()
        
        for s in strs:
            temp = store
            for char in s:
                if char not in temp.storage:
                    temp.storage[char] = 1
                else:
                    temp.storage[char] += 1
                
                if temp.next is None:
                    temp.next = trie()
                temp = temp.next
        
        while store is not None:
            if len(store.storage) == 1:
                item = store.storage.items()[0]
                if item[1] == len(strs):
                    res.append(item[0])
                    store = store.next
                else:
                    break
            else:
                break
        
        return "".join(res)