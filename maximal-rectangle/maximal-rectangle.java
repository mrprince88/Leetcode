class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int n=matrix.length, m=matrix[0].length;
        int []dp=new int[m];
        int maxArea=-1;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(matrix[i][j]=='0') dp[j]=0;
                else dp[j]++;
            }
            maxArea=Math.max(maxArea,solve(dp));
        }
        
        return maxArea;
    }
    
    int solve(int []heights) {
        Stack<Integer> stack=new Stack<>();
        
        int maxArea=0,tp,currArea=0;
        
        int i=0,n=heights.length;
        
        while(i<n) {
            
            if(stack.isEmpty() || heights[stack.peek()]<=heights[i])
                stack.push(i++);
            
            else {
                tp=stack.peek();
                stack.pop();
                currArea=heights[tp]*(stack.isEmpty()? i: i-stack.peek()-1);
                maxArea=Math.max(maxArea,currArea);
            }
        }
        while(!stack.isEmpty()) {
            tp=stack.peek();
            stack.pop();
            currArea=heights[tp]*(stack.isEmpty()?i: i-stack.peek()-1);
            maxArea=Math.max(maxArea,currArea);
        }
        return maxArea;
    }
}