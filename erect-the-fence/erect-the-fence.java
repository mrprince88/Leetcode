class Solution {
    public int[][] outerTrees(int[][] trees) {
        int n=trees.length;
        if(n<=1) return trees;
        sort(trees,bottomLeft(trees));
        Stack<int[]> stack = new Stack<>(); 
        stack.push(trees[0]);                      
        stack.push(trees[1]);                              
        for (int i = 2; i < n; i++) {
            int[] top = stack.pop();                                
            while (compAngle(stack.peek(), top, trees[i]) < 0)
                top = stack.pop();
            stack.push(top);
            stack.push(trees[i]);
        }
        
       int [][]res=new int[stack.size()][2];
        int c=0;
        
        for(int[] i: stack)
            res[c++]=i;
        
        return res;
    }
    
    // get bottom left point
    int[] bottomLeft(int[][] trees) {
        int []bottomLeft=trees[0];
        
        for(int []tree:trees) {
           if(bottomLeft[1] > tree[1] || (bottomLeft[1]==tree[1] && bottomLeft[0]>tree[1]))
              bottomLeft=tree;
        }
        return bottomLeft;
    }
    
    
    // anticlockwise +ve, clockwise -ve, 0 collinear
    public int compAngle(int p1[], int[] p2, int[] p3){
        int[] firstVector = new int[]{p2[0]-p1[0], p2[1]-p1[1]};
        int[] secondVector = new int[]{p3[0]-p2[0], p3[1]-p2[1]};
        return firstVector[0]*secondVector[1] - firstVector[1]*secondVector[0];
    }
    
    int compDist(int []p1,int []p2) {
        return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    }
    
    // sort points according to angle with the reference to the bottom left point
    void sort(int [][]trees,int[]ref) {
        Arrays.sort(trees,(a,b)->{
            int compAngle=compAngle(a,ref,b);
            int res= compAngle==0 ? compDist(a,ref)-compDist(b,ref) : compAngle;
            return res;
        });
        
        // find collinear points from the end
        int[] q=trees[trees.length-1];
        int i=trees.length-2;
        while(i>=0 && compAngle(trees[i],ref,q)==0)
            i--;
        
        // reverse sort collinear points
        int low=i+1,high=trees.length-1;
        
        while(low<high) {
            swap(trees,low,high);
            low++; high--;
        }
    }
    
    void swap(int [][]trees,int l,int r) {
        int []temp=trees[l];
        trees[l]=trees[r];
        trees[r]=temp;
   }
}