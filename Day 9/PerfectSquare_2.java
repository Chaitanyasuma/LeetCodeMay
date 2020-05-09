class Solution {
    public boolean isPerfectSquare(int num) {
        //binary search method
        long left = 1; //long used because TLE error in case of big values
        long right = num;
        while (left <= right) {
            long mid = left - (left - right) / 2;
            if(mid*mid == num) {
                return true;
            }
            else if(mid * mid < num) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}