class Solution {
    public int beautySum(String s) {
        char []str=s.toCharArray();
        int ans=0;
        int []freq=new int[26];
        
        for(int i=0;i<str.length;i++) {
            
            for(int k=0;k<26;k++) freq[k]=0;
            
            for(int j=i;j<str.length;j++) {
                freq[str[j]-'a']++;
                int max=-1,min=5001;
                
                for(int k=0;k<26;k++) {
                    if(freq[k]!=0) {
                        min=Math.min(min,freq[k]);
                        max=Math.max(max,freq[k]);
                    }
                }
                ans+=max-min;
            }
        }
        return ans;
    }
}