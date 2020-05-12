class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        for(i = 0; i < nums.length - 1; i+=2) {
            if(nums[i] != nums[i + 1]) {
                break;
            }
        }
        return nums[i];
    }
}