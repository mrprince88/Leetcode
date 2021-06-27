class Solution {
    public int maxArea(int[] height) {
        int n=height.length, i=0, j=n-1, maxArea=0;
        
        while(i<j) {
            maxArea=Math.max(maxArea,Math.min(height[i],height[j])*(j-i));
            
            if(height[i]<=height[j])
                i++;
            else 
                j--;
        }
        return maxArea;
    }
}