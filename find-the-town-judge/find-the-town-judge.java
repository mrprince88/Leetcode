class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0 && n==1) return 1;
        
        int []arr=new int[n+1];
        int []arr2=new int[n+1];
        
        for(int []edge: trust) {
            arr[edge[1]]++; arr2[edge[0]]++;
        }
        
        for(int i=0;i<=n;i++)
            if(arr[i]==n-1 && arr2[i]==0) return i;
        
        return -1;
    }
}