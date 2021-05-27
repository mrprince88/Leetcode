class Solution {
    public int maxProduct(String[] words) {
        int n=words.length;
        int []bytes=new int[n];
        
        for(int i=0;i<n;i++) {
            int res=0;
            for(int j=0;j<words[i].length();j++) {
                res|=(1<<(words[i].charAt(j)-'a'));
            }
            bytes[i]=res;
        }
        
        int max=0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if((bytes[i]&bytes[j])==0)
                    max=Math.max(max,words[i].length()*words[j].length());
            }
        }
                
        return max;        
    }
}