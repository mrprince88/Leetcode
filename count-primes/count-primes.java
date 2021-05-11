class Solution {
    public int countPrimes(int n) {
        if(n<3)
            return 0;
        
        boolean[] isPrime=new boolean[n];
        int count=n-2;
        
        for(int i=2;i<n;i++)
            isPrime[i]=true;
        
        for(int i=2;i*i<n;i++) {
            if(!isPrime[i])
                continue; 
            for(int j=i*i;j<n;j+=i) {
                if(isPrime[j]) {
                    isPrime[j]=false;
                    count--;
                }
            }
        }
        return count;
    }
}