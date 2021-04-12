class Solution {
    public boolean divisorGame(int n) {
        if(n==1)
            return false;
        int c=0;
        while(n!=1) {
            c++;
            n--;
        }
        if((c&1)==1)
            return true;
        return false;
    }
}