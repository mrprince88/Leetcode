class NumArray {
    
    static class SegTree {
        int start,end,sum;
        SegTree left,right;
        
        SegTree(int l,int r) {
            start=l; end=r;
            left=null; right=null;
            sum=0;
        }
    }
    
    SegTree root;
    
    public NumArray(int[] nums) {
        root=buildTree(nums,0,nums.length-1);
    }
    
    SegTree buildTree(int []nums,int start,int end) {
        if(start>end)
            return null;
        
        SegTree seg=new SegTree(start,end);
        if(start==end) seg.sum=nums[start];
        else {
            int mid=start+(end-start)/2;
            seg.left=buildTree(nums,start,mid);
            seg.right=buildTree(nums,mid+1,end);
            seg.sum=seg.left.sum+seg.right.sum;
        }
        return seg;
    }
    
    public void update(int index, int val) {
        update(root,index,val);
    }
    
    private void update(SegTree root,int index,int val) {
        if(root.start==root.end) root.sum=val;
        else {
            int mid=root.start+(root.end-root.start)/2;
            if(index<=mid)
                update(root.left,index,val);
            else
                update(root.right,index,val);
            root.sum=root.left.sum+root.right.sum;
        }
    }
    
    public int sumRange(int left, int right) {
        return sumRange(root,left,right);
    }
    
    private int sumRange(SegTree root,int left,int right) {
        if(root.start==left && root.end==right) return root.sum;
        else {
            int mid=root.start+(root.end-root.start)/2;
            if(right<=mid) return sumRange(root.left,left,right);
            else if(left>mid) return sumRange(root.right,left,right);
            else return sumRange(root.left,left,mid)+ sumRange(root.right,mid+1,right);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */