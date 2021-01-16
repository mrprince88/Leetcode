class Solution {
    public int largestRectangleArea(int[] heights) {
        
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
