class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        else:
            dic = Counter(nums)
            for i in dic:
                if (dic[i] > (len(nums)/2)):
                    break
            return i
                