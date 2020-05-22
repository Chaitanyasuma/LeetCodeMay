class Solution {
    public String frequencySort(String s) {
        int freq[] = new int[128];
        char[] cA = s.toCharArray();    
        for(char c:cA) {
            freq[c]++;
        }   
        int count = 0;
        char[] res = new char[s.length()];
        while(count < s.length()) {
            int max = -1;
            int index = -1;
            for(int j = 0; j < 128; j++) {
                if(freq[j] > max) {
                    max = freq[j];
                    index = j;
                }  
            }
            while(freq[index] > 0) {
                res[count++] = (char)index;  
                freq[index]--;
            }
        }
        return new String(res);
    }
}
