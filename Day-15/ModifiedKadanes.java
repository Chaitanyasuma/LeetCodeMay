class Solution {
    public int maxSubarraySumCircular(int[] A) {
        if(CheckMinimum(A) < 0) {
            return CheckMinimum(A);
        }
        return maxSum(A);
    }
    public int kadane(int A[]) {
        int sum = 0;
        int max = 0;
        for(int i = 0; i < A.length; i++) { //good old kadane's
            sum = sum + A[i];    
            max = Math.max(sum, max);
            if(sum < 0) { //i.e. negative elements
                sum = 0;
            }
        }   
        return max;
    }
    public int maxSum(int A[]) { 
        int ans1 = kadane(A); 
        int ans2 = 0; 
        for(int i = 0; i < A.length; i++) { 
            ans2 += A[i];
            A[i] = - A[i];
        } 
        ans2 += kadane(A); 
        return Math.max(ans2, ans1);
    }
    public int CheckMinimum(int A[]) {
        int min = A[0];
        for(int i = 0; i < A.length; i++) {
            if(A[i] < 0)
                min = Math.max(A[i], min);
            else 
                return 0; 
        }
        return min;
    }
}