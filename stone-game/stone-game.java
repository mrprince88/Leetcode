class Solution {
    public boolean stoneGame(int[] piles) {
        
        int i=0, j=piles.length-1,c=0;
        
        while(i<j) {
            if(piles[i]<piles[j])
                j--;
            else
                i++;
            c++;
        }
        return c%2!=0;
    }
}