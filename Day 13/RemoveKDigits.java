class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) {
            return "0";
        }    
        return rec(num, num, k, 1);
    }
    public String rec(String num, String orig, int k, int callno) {
        if(num.length() < (callno + k - 1))
            return orig;
        int n = Integer.parseInt(num.substring(k));
        return Integer.toString(Math.min(n, Integer.parseInt(rec((orig.substring(callno, callno + k) + orig.substring(0, callno) + orig.substring(callno + k)), orig, k, callno + 1))));
    }
}