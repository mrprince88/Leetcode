class Solution {
    public int[] threeEqualParts(int[] arr) {
        int n=arr.length;
        
        int totalOnes=0;
        
        
        for(int i: arr)
            totalOnes+=i;
        
        if(totalOnes%3!=0) return new int[]{-1,-1};
        
        totalOnes/=3;
        
        if(totalOnes==0)
            return new int[]{0,n-1};
        
        int i1=-1,j1=-1,i2=-1,j2=-1,i3=-1,j3=-1,count=0;
        
        for(int i=0;i<n;i++) {
            if(arr[i]==1) {
                count++;
                if(count==1) i1=i;
                if(count==totalOnes) j1=i;
                if(count==totalOnes+1) i2=i;
                if(count==2*totalOnes) j2=i;
                if(count==2*totalOnes+1) i3=i;
                if(count==3*totalOnes) j3=i;
            }
        }
        
        int []part1=Arrays.copyOfRange(arr,i1,j1+1);
        int []part2=Arrays.copyOfRange(arr,i2,j2+1);
        int []part3=Arrays.copyOfRange(arr,i3,j3+1);
        
        if(!Arrays.equals(part1,part2) || !Arrays.equals(part2,part3))
            return new int[]{-1,-1};
        
        int trailingZerosLeft=i2-j1-1;
        int trailingZerosMid=i3-j2-1;
        int trailingZeros=n-j3-1;
        
        if(trailingZeros > Math.min(trailingZerosLeft,trailingZerosMid))
            return new int[]{-1,-1};
        
        return new int[]{j1+trailingZeros,j2+trailingZeros+1};
    }
}