#very high time complexity because count function takes O(n) time in every iteration 
class Solution:
    def firstUniqChar(self, s: str) -> int:
        index = 0
        ans = -1
        for char in s:
            count = s.count(char)
            if count == 1:
                ans = index
                break
            index = index + 1
        return ans
