#32ms
class Solution:
    def findComplement(self, num: int) -> int:
        string = bin(num)
        string = string[2:]
        index = 0
        ans = 0
        for i in reversed(string):
            if i == '0':
                ans = ans + (pow(2, index) * 1)
            index = index + 1
        #end for
        return ans