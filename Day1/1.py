# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):
class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        flag = 0 #to keep track of bad version
        l = 0
        r = n
        while(flag != 1):
            check = l + (r - l)//2
            if isBadVersion(check) == True:
                if isBadVersion(check - 1) == True:
                    r = check
                else:
                    flag = check
                    break
            else:
                l = check + 1
        #end while
        return flag