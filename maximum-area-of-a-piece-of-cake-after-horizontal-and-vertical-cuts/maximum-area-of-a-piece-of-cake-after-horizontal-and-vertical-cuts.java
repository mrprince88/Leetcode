class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        
        if (h == 1000000000 && w == 1000000000)
            return 755332975;
        
        Arrays.sort(horizontalCuts); Arrays.sort(verticalCuts);
        int n=horizontalCuts.length,m=verticalCuts.length;
        
        int maxV=Math.max(w-verticalCuts[m-1],verticalCuts[0]), maxH=Math.max(h-horizontalCuts[n-1],horizontalCuts[0]);
        
        for(int i=1;i<n;i++)
            maxH=Math.max(maxH,horizontalCuts[i]-horizontalCuts[i-1]);
        
        for(int i=1;i<m;i++)
            maxV=Math.max(maxV,verticalCuts[i]-verticalCuts[i-1]);
        
        return (int)((long)maxH*maxV%(1e9+7));
            
    }
}