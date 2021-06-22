class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<StringBuffer>[] waiting=new List[26];
        int ans=0;
        for(int i=0;i<26;i++) waiting[i]=new ArrayList<>();
        
        for(String w:words) waiting[w.charAt(0)-'a'].add(new StringBuffer(w));
        
        for(char i:s.toCharArray()) {
            List<StringBuffer> a=waiting[i-'a'];
            waiting[i-'a']=new ArrayList<>();
            
            for(StringBuffer j:a) {
                j.deleteCharAt(0);
                if(j.length()!=0)
                    waiting[j.charAt(0)-'a'].add(j);
                else ans++;
            }
        }
        return ans;
    }
}