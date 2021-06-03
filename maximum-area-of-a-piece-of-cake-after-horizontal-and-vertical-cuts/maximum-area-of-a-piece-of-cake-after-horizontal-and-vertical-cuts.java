class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        Arrays.sort(horizontalCuts); Arrays.sort(verticalCuts);
        int maxV=verticalCuts[0],maxH=horizontalCuts[0],n=horizontalCuts.length,m=verticalCuts.length;
        
        for(int i=1;i<n;i++)
            maxH=Math.max(maxH,horizontalCuts[i]-horizontalCuts[i-1]);
        maxH=Math.max(maxH,h-horizontalCuts[n-1]);
        
        for(int i=1;i<m;i++)
            maxV=Math.max(maxV,verticalCuts[i]-verticalCuts[i-1]);
        maxV=Math.max(maxV,w-verticalCuts[m-1]);
        
        return (int)((long)maxH*maxV%(1e9+7));
            
    }
}