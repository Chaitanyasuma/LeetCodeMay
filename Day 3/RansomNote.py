class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        flag = 0
        for char in ransomNote:
            if char in magazine:
                magazine = magazine.replace(char, '-', 1) #replace the existing character with null, but only once
            else:
                flag = 1
                break
        if flag == 0:
            return True
        else:
            return False