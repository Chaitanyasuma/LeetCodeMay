class Trie {
    private class TrieNode {
        TrieNode[] children = new TrieNode[26]; //initialised with the number of alphabets i.e. 26 as children
        boolean end;
        public TrieNode() {
            end = false; 
            for(int i = 0; i < 26; i++) 
                children[i] = null; 
        }
    }
    private TrieNode root;
    public Trie() {     //  constructor
        root = new TrieNode();    
    }
    //static Trie root = new Trie();
    public void insert(String word) {      
        TrieNode ptr = root; 
        int index;
        for(int i = 0; i < word.length(); i++) 
        { 
            index = word.charAt(i) - 'a'; //since all lowercase, this will generate a value between 0-25 
            if(ptr.children[index] == null) {
                ptr.children[index] = new TrieNode();
            } 
            ptr = ptr.children[index]; //moved to the currently added alphabet's trie
        } 
        ptr.end = true; //to mark the end of a particular word   
    }
    public boolean search(String word) {
        TrieNode ptr = root; 
        int index;
        int flag = 0;
        for(int i = 0; i < word.length(); i++) 
        { 
            if (ptr != null) {
                index = word.charAt(i) - 'a'; 
                if(ptr.children[index] == null) {
                    return false; //not found that alphabet space occupied
                }
                ptr = ptr.children[index];     
            }
            else 
                flag = 1; //i.e. word bigger than the found child
        } 
        if (ptr.end == true && flag == 0)
            return true; 
        return false;
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ptr = root; 
        int index;
        for(int i = 0; i < prefix.length(); i++) 
        { 
            if (ptr != null) {
                index = prefix.charAt(i) - 'a'; 
                if(ptr.children[index] == null) {
                    return false; //not found that alphabet space occupied
                }
                ptr = ptr.children[index];     
            }
            else 
                return false;
        } 
        return true;    
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */