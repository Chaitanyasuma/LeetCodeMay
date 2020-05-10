#Time taken = 56 ms
class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        count = 0
        for char in S:
            if char in J:
                count = count + 1
            #end if
        #end for
        return count