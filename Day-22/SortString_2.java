class Solution {
    public String frequencySort(String s) {
        int freq[] = new int[128];
        char[] cA = s.toCharArray();    
        for(char c:cA) {
            freq[c]++;
        }   
        int count = 0;
        String res = "";
        char maxchar = 'a';
        while(count < s.length()) {
            int max = -1;
            int index = -1;
            for(int i = 0; i < s.length(); i++) {
                if(freq[s.charAt(i)] > max) {
                    max = freq[s.charAt(i)];
                    index = s.charAt(i);
                    maxchar = s.charAt(i);
                }  
            }
            for(int j = 0; j < max; j++) {
                res = res + maxchar;    
            }
            freq[index] = -1;
            count += max;
        }
        return res;
    }
}
