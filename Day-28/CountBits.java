class Solution {
    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        arr[0] = 0;
        if (num  == 0)
            return arr;
        arr[1] = 1;
        if (num == 1)
            return arr; 
        arr[0] = 0;
        arr[1] = 1;
        int powerOfTwo = 2;
        for(int i = 2; i <= num; i++) {
            if (powerOfTwo - i == 0) { //i.e. it is an power of two
                powerOfTwo *= 2; //upper limit changed
                arr[i] = 1; //all power of 2 have only one 1
            }
            else {
                arr[i] = 1 + arr[i - (powerOfTwo / 2)]; //how far it is from the lower limit 2^n
            }
        }
        return arr;
    }
}