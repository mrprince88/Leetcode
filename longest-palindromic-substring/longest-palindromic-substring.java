class Solution {
    public String longestPalindrome(String str) {
        int[] current={0,1};
        for(int i=1;i<str.length();i++) {
            int []odd=solve(str,i-1,i+1);
            int []even=solve(str,i-1,i);
            
            int oddIndex=odd[1]-odd[0],evenIndex=even[1]-even[0],
            currentIndex=current[1]-current[0];
            
            if(currentIndex<Math.max(oddIndex,evenIndex)) {
                if(oddIndex>currentIndex)
                    current=odd;
                else
                    current=even;
            }
        }
        return str.substring(current[0],current[1]);
    }
    
    int[] solve(String str,int pos1,int pos2) {
        while(pos1>=0 && pos2<str.length()) {
            if(str.charAt(pos1)!=str.charAt(pos2))
                break;
            pos1--; pos2++;
        }
        return new int [] {pos1+1,pos2};
    }
}
