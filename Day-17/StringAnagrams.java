class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < p.length(); i++) {
            count[((int)p.charAt(i)) - 97]++;
        }
        int j = 0, i = 0; //this is for the sliding window
        int chars = p.length(); //no.of chars to be searched
        while(j < s.length()) {
            if(count[((int)s.charAt(j)) - 97] > 0) { //i.e. character present in the other string
                chars--; //i.e. no of chars to be searched are lessened
            }
            count[((int)s.charAt(j)) - 97]--;//then, decrease freq and check the whole window, else slide
            j++;
            if(chars == 0) {
                arr.add(i);
            }
            /* window is complete, i only moves if j has moved enough 
            *  and count of chars is  still not zero thus, 
            *  window should be slid and count of chars should be increased i.e. restored */
            if(j - i == p.length()) { 
                if(count[((int)s.charAt(i)) - 97] >= 0)
                    chars++;   
                count[((int)s.charAt(i)) - 97]++;
                i++;
            }        
        }
        return arr;
    }
}