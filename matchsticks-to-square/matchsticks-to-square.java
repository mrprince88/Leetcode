class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n=matchsticks.length,sum=0;
        for(int i: matchsticks) sum+=i;
        if(sum%4!=0) return false;
        
        Arrays.sort(matchsticks);
        
        return check(matchsticks,n-1,new int[4],sum/4);
    }
    
    boolean check(int[]a,int index,int []sums,int target) {
        if(index==-1) return true;
        
        for(int i=0;i<4;i++) {
            if(sums[i]+a[index]>target) continue;
            sums[i]+=a[index];
            if(check(a,index-1,sums,target)) return true;
            sums[i]-=a[index];
        }
        return false;
    }
}