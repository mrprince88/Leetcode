class Solution {
    
    public int twoEggDrop(int n) {
        int eggs=2;
        
        return solver(eggs,n,new int[eggs+1][n+1]);
    }
    
    int solver(int eggs,int floors,int [][]dp) {
        if(eggs==1 || floors<=1) 
            return floors;
        
        if(dp[eggs][floors]>0)
            return dp[eggs][floors];
        
        int min=Integer.MAX_VALUE;
        
        for(int i=1;i<=floors;i++)
            min=Math.min(min, 1 + Math.max(solver(eggs-1,i-1,dp), solver(eggs,floors-i,dp)));
        
        dp[eggs][floors]=min;
        
        return dp[eggs][floors];
    }
    
//     public int twoEggDrop(int n) {
//         // x+(x-1)+(x-2)....1<=n
//         // x^2+x-2n<=0
        
//         int a=1,b=1,c=-2*n;
        
//         int d=(b*b)-(4*a*c);
        
//         double x=((-1 * b + Math.sqrt(d))/2);
        
//         return (int)Math.ceil(x);
//     }
    
}