class Solution {
    public int beautySum(String s) {
        char []str=s.toCharArray();
        int ans=0;
        List<int[]> list=new ArrayList<>();
        int []freq=new int[26];
        list.add(new int[26]);
        
        for(char i: str) {
            freq[i-'a']++;
            list.add(Arrays.copyOf(freq,26));
        }
        
        for(int i=0;i<str.length;i++) {
            for(int j=i+1;j<str.length+1;j++) {
                int[] left=list.get(i);
                int[] right=list.get(j); 
                
                int max=-1,min=501;
                
                for(int k=0;k<26;k++) {
                    if(left[k]!=right[k]) {
                    max=Math.max(max,right[k]-left[k]);
                    min=Math.min(min,right[k]-left[k]);
                    }
                }
                ans+=max-min;
            }
        }
        return ans;
    }
}