class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();
        int []prev=new int[n],next=new int[n];
        
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i])
                stack.pop();
            if(!stack.isEmpty())
                prev[i]=i-stack.peek();
            else
                prev[i]=i+1;
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
                stack.pop();
            if(!stack.isEmpty())
                next[i]=stack.peek()-i;
            else
                next[i]=n-i;
            stack.push(i);
        }
        
        long ans=0,mod=(int)(1e9+7);
        
        for(int i=0;i<n;i++)
            ans=(ans+(long)arr[i]*next[i]*prev[i])%mod;
        
        return (int)ans;
    }
}