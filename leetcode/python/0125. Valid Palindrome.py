# Time complexity: O(N)
# Space complexity: O(N)

class Solution(object):
    def isPalindrome(self, s):
        lower = s.lower()

        a = ord("a")
        z = ord("z")
        digit_0 = ord("0")
        digit_9 = ord("9")

        str_list = []
        
        for char in lower:
            curr = ord(char)
            if curr >= a and curr <= z or curr >= digit_0 and curr <= digit_9:
                str_list.append(char)
        
        left = 0
        right = len(str_list) - 1

        while right >= left:
            if str_list[left] != str_list[right]:
                return False
            left += 1
            right -= 1
        return True 