# Time complexity: O(s), where s is the length of the string
# Space complexity: O(1)

class Solution(object):
    def romanToInt(self, s):
        res = 0
        skip = False
        
        mapping = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000,
        }

        for i in range(len(s)):
            if skip:
                skip = not skip
                continue
            if i < len(s) - 1 and s[i] == "I" and (s[i+1] == "V" or s[i+1] == "X"):
                if s[i+1] == "V":
                    res += 4
                else:
                    res += 9
                skip = True
            elif i < len(s) - 1 and s[i] == "X" and (s[i+1] == "L" or s[i+1] == "C"):
                if s[i+1] == "L":
                    res += 40
                else:
                    res += 90
                skip = True
            elif i < len(s) - 1 and s[i] == "C" and (s[i+1] == "D" or s[i+1] == "M"):
                if s[i+1] == "D":
                    res += 400
                else:
                    res += 900
                skip = True
            else:
                res += mapping[s[i]]
        return res