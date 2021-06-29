class Solution {
    int n;
    public boolean circularArrayLoop(int[] nums) {
        n=nums.length;
        
        int []visited=new int[n];
        
        for(int i=0;i<n;i++)
            if(visited[i]==0 && dfs(nums,visited,i)) return true;
        
        return false;
    }
    
    boolean dfs(int[] nums,int []visited,int curr) {
        if(visited[curr]==2) return false;
        if(visited[curr]==1) return true;
        
        visited[curr]=1;
        int next=(curr+nums[curr])%n;
        if(next<0) next+=n;
        
        if(next==curr || nums[next]*nums[curr]<0) {
            visited[curr]=2;
            return false;
        }
        
        if(dfs(nums,visited,next)) return true;
        visited[curr]=2;
        return false;
    }
}