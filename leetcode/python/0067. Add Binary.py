# Time complexity: O(N)
# Space complexity: O(N)


class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        s = self.binary2dec(a) + self.binary2dec(b)
        return self.dectobinary(s)

    def binary2dec(self, bin):
        currExp = 1
        res = 0
        for i in range(len(bin)-1, -1, -1):
            if bin[i] == "1":
                res += currExp
            currExp *= 2
        return res

    def dectobinary(self, dec):
        res = []
        while dec > 0:
            if dec % 2 == 0:
                res.append("1")
            else:
                res.append("0")
            dec /= 2
        return "".join(res)