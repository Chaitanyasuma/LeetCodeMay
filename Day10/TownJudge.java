//time = 2ms
class Solution {
    public int findJudge(int N, int[][] trust) {
        int flag[] = new int[N];
        int count = 0;
        for(int i = 0; i < N; i++) {
            flag[i] = 0;
        }
        for(int i = 0; i < trust.length; i++) {
            flag[(trust[i][0]) - 1] = 1; //flagged the element that trusts someone else 
        }
        int trustee = -1;
        for(int j = 0; j < flag.length; j++) {
            if(flag[j] != 1) {
                trustee = j;
                break;
            }
        }
        if(trustee != -1) { //i.e. trusts no one
            for(int i = 0; i < trust.length; i++) {
                if(trust[i][1] == (trustee + 1)) {
                    count++;
                }
            }
        }
        if(count == (N - 1))
            return (trustee + 1);
        else
            return -1;
    }
}