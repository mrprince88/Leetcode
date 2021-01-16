class Solution {
    public int nextGreaterElement(int n) {
        
        char []s=Integer.toString(n).toCharArray();
            
        int i=s.length-2;
        
        // find first non decreasing position from right
        while(i>=0 && s[i+1]<=s[i])
            i--;
        
        if(i==-1)
            return -1;
        
        // swapping it first position smaller than it
        int j=s.length-1;
        
        while(j>=0 && s[j]<=s[i])
            j--;
        
        swap(s,i,j);
        
        //reversing it
        i++;
        int k= s.length-1;
         while (i < k) {
            swap(s, i, k);
            i++;
            k--;
        }
        
     try {
            return Integer.parseInt(new String(s));
        } catch (Exception e) {
            return -1;
        }
    }
    
    void swap(char []s,int i,int j) {
        char t=s[i];
        s[i]=s[j];
        s[j]=t;
    }
}
