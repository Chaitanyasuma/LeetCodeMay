//accepted, O(logn) time complexity and O(1) space complexity
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return binsearch(0, nums.length, nums);
    }
    public int binsearch(int l, int r, int[] nums) {
        int mid = l + ((r - l) / 2); //found mid position
        if(mid + 1 < nums.length && mid - 1 >= 0) {
            if(nums[mid] == nums[mid + 1]) {
                if(mid % 2 == 0) //i.e. even number, then element we want is ahead of this
                    return binsearch(mid + 2, r, nums);
                else
                    return binsearch(l, mid - 1, nums);
            }
            else if(nums[mid] == nums[mid - 1]) {
                if(mid % 2 == 0) //i.e. even number, then element we want is behind
                    return binsearch(l, mid - 2, nums);
                else
                    return binsearch(mid + 1, r, nums);    
            }
        }
        return nums[mid];
    }
}