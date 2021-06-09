class Solution {
    public int trap(int[] height) {
        int n=height.length,left=0,right=n-1,maxLeft=0,maxRight=0,res=0;
        
        while(left<right) {
            if(height[left]<=height[right]) {
                if(maxLeft<=height[left]) maxLeft=height[left];
                else res+=maxLeft-height[left];
                left++;
            }
            else {
                if(maxRight<=height[right]) maxRight=height[right];
                else res+=maxRight-height[right];
                right--;
            }
        }
        return res;
    }
}