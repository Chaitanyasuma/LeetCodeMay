//Number format exception, dont know how to resolve
class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) {
            return "0";
        }    
        
        return (Long.toString(rec(Long.parseLong(num), k))); //no digit picked yet so k = 3
    }
    public long rec(long num, int k) {
        if(k == 0) { //i.e. all 3 digits have been picked to remove
            return num;
        }
        if(num == 0) {
            return 10;
        }
        long n1 = (rec((num / 10), k) * 10) + (num % 10); //keep the digit
        long n2 = rec(num / 10, k - 1);  //remove the digit
        return (Math.min(n1, n2));
    }
}