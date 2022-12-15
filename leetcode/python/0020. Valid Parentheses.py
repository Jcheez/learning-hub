# Time complexity: O(N)
# Space complexity: O(N)

class Solution(object):
    def isValid(self, s):
        opening = ['(', '{', '[']

        stack = []

        for bracket in s:
            if bracket in opening:
                stack.append(bracket)
            else:
                if len(stack) == 0:
                    return False
                brack = stack.pop()
                if bracket == ')' and brack != '(':
                    return False
                elif bracket == '}' and brack != '{':
                    return False
                elif bracket == ']' and brack != '[':
                    return False
        
        return len(stack) == 0