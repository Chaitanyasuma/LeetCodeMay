class Solution {
    public String frequencySort(String s) {
        int freq[] = new int[85];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) - 'a' >= -32 && s.charAt(i) - 'a' <= -7) { //i.e. 65 to 90 or 0-25 in freq
                freq[s.charAt(i) - 'A']++;      
            }
            else if(s.charAt(i) - 'a' < 0) { //i.e. 97-122 or 26-51 in freq
                freq[(s.charAt(i) - ' ') + 52]++; //comparing with space ;-;    
            }
            else {
                freq[(s.charAt(i) - 'a') + 26]++;    
            }
        }    
        int count = 0;
        String res = "";
        char maxchar = 'a';
        while(count < s.length()) {
            int max = -1;
            int index = -1;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) - 'a' >= -32 && s.charAt(i) - 'a' <= -7) {  //i.e. 65 to 90 or 0-25 in freq 
                    if(max < freq[s.charAt(i) - 'A']) {
                        max = freq[s.charAt(i) - 'A'];
                        maxchar = s.charAt(i);
                        index = s.charAt(i) - 'A';
                    }    
                }
                else if(s.charAt(i) - 'a' < 0) {
                    if(max < freq[s.charAt(i) - ' ' + 52]) {
                        max = freq[s.charAt(i) - ' ' + 52];
                        maxchar = s.charAt(i);
                        index = s.charAt(i) - ' ' + 52;
                    }      
                }
                else {
                    if(max < freq[s.charAt(i) - 'a' + 26]) {
                        max = freq[s.charAt(i) - 'a' + 26];
                        maxchar = s.charAt(i);
                        index = s.charAt(i) - 'a' + 26;
                    }   
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
