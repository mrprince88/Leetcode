class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length(),m=t.length();
        
        if(n!=m) return false;
        
        int []map=new int[256];
        boolean []used=new boolean[256];
        char []s1=s.toCharArray();
        char []s2=t.toCharArray();
        
        for(int i=0;i<n;i++) {
            if(map[s1[i]]==0) {
                if(used[s2[i]]) return false;
                map[s1[i]]=s2[i];
                used[s2[i]]=true;
            }
            else if(map[s1[i]]!=s2[i]) return false;
        }
        return true;
    }
}