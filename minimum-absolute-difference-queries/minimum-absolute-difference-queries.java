class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int [][]freq=new int[nums.length+1][101];
        int []curr=new int[101];
        int c=1;
        
        for(int i:nums) {
            curr[i]++;
            freq[c++]=Arrays.copyOf(curr,101);
        }
        
        int []ans=new int[queries.length];
        for(int i=0;i<queries.length;i++) {
            int []left=freq[queries[i][0]], right=freq[queries[i][1]+1];
            int prev=0, diff=101;
            for(int j=0;j<101;j++) {
                if(left[j]!=right[j])  {
                    if(prev!=0) diff=Math.min(diff,j-prev);
                    prev=j;
                }
            }
            if(diff==101) diff=-1;
            ans[i]=diff;
        }
        return ans;
    }
}