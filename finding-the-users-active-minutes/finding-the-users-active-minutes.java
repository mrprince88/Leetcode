class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int []ans=new int[k];
        int n=logs.length;
        HashSet<Integer> set1=new HashSet<>();
        
        for(int i=0;i<n;i++) {
            
            if(set1.contains(logs[i][0]))
                continue;
            
            set1.add(logs[i][0]);
            HashSet<Integer> set=new HashSet<>();
            
            for(int j=i;j<n;j++) {
                if(logs[i][0]==logs[j][0])
                    set.add(logs[j][1]);
            }
            
            ans[set.size()-1]++;
        }
        
        return ans;
    }
}