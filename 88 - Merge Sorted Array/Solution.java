class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p=m-1,q=n-1,e=nums1.length-1;
        
        while(e>=0) {
            
            int first=(p>=0)?nums1[p]:Integer.MIN_VALUE;
            int second=(q>=0)?nums2[q]:Integer.MIN_VALUE;
            
            if(first>second) {
                nums1[e]=first;
                e--; p--;
            }
            
            else {
                nums1[e]=second;
                e--; q--;
            }
        }
    }
}
