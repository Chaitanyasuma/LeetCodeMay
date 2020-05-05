#192 ms
class Solution:
    def firstUniqChar(self, s: str) -> int:
        index = 0
        ans = -1
        for char in s:
            if index == 0:
                indexf = s.find(char, index + 1)
            elif index == (len(s) - 1):
                indexf = s.find(char, 0, index)	
            else:
                index1 = s.find(char, 0, index)
                index2 = s.find(char, index + 1)
                if index1 == -1 and index2 == -1:
                    indexf = -1
            if indexf == -1: #i.e. no character like that has appeared before or after
                ans = index
                break
            else:
                index = index + 1
        return ans
            
