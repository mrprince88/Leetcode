class Solution {
    int ans;
    Map<String,Integer> map;
    Set<String> set;
    public int longestStrChain(String[] words) {
        map=new HashMap<>();
        set=new HashSet<>();
        Collections.addAll(set,words);
        ans=-1;
        
        for(String i:set)
            ans=Math.max(ans,dfs(i));
        
        return ans;
    }
    
    private int dfs(String s) {
        if(map.containsKey(s))
            return map.get(s);
        
        int max=1,n=s.length();
        StringBuffer sb=new StringBuffer(s);
        
        for(int i=0;i<n;i++) {
            sb.deleteCharAt(i);
            String str=sb.toString();
            
            if(set.contains(str)) {
                max=Math.max(max,1+dfs(str));
            }
            sb.insert(i,s.charAt(i));
        }
        map.put(s,max);
        return max;
    }
}