class Solution {
    public int minimumDeletions(String s) {
        int endA = 0, endB = 0,len=s.length();
        
        for (int i=0; i<len; i++) {
            if (s.charAt(i) == 'a') {
                endB++;
            }
            else {
                endB = Math.min(endA, endB);
                endA++;
            }
        }
        
        return Math.min(endA, endB);
    }
}