#Time taken = 40 ms
class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        count = 0
        for char in J:
            index = S.find(char) #returns first index
            while index != -1:
                count = count + 1
                index = S.find(char, index + 1)
        return count  