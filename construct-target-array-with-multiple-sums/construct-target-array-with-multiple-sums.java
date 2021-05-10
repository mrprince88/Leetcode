class Solution {
    public boolean isPossible(int[] target) {
        
        if(target.length==1)
            return target[0]==1;
        
        while(true) {
            int n=target.length,max=-1,pos=-1,sum=0;
            for(int i=0;i<n;i++) {
                sum+=target[i];
                if(max<target[i]) {
                    max=target[i];
                    pos=i;
                }
            }
            if(max<1 || pos==-1) return false;
            if(sum==target.length) return true;
            int prev=max%(sum-max);
            if(prev==0) prev=sum-max;
            if(prev==max) return false;
            target[pos]=prev;
        }
        
    }
}