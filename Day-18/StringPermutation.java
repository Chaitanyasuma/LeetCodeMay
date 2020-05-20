class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            count[((int)s1.charAt(i)) - 97]++;
        }
        int j = 0, i = 0; //this is for the sliding window
        int chars = s1.length(); //no.of chars to be searched
        while(j < s2.length()) {
            if(count[((int)s2.charAt(j)) - 97] > 0) { //i.e. character present in the other string
                chars--; //i.e. no of chars to be searched are lessened
            }
            count[((int)s2.charAt(j)) - 97]--;//then, decrease freq and check the whole window, else slide
            j++;
            if(chars == 0)
                return true; 
            /* window is complete, i only moves if j has moved enough 
            *  and count of chars is  still not zero thus, 
            *  window should be slid and count of chars should be increased i.e. restored */
            if(j - i == s1.length()) { 
                if(count[((int)s2.charAt(i)) - 97] >= 0)
                    chars++;   
                count[((int)s2.charAt(i)) - 97]++;
                i++;
            }        
        }
        return false;
    }
}