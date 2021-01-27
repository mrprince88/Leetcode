class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int l=0,r=1000001;
        
        while(l < r) {
            int m = (l + r) / 2;
            if(bfs(heights, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    
    int [][]dir={{1,0},{0,1},{-1,0},{0,-1}};
    
    boolean bfs(int [][]h,int limit) {
        int r=h.length, c=h[0].length;
        
        Queue<int[]> queue=new LinkedList<>();
        boolean[][]visited=new boolean[r][c];
        visited[0][0]=true;
        queue.add(new int[]{0,0});
        
        while(queue.size()>0) {
            int x=queue.peek()[0];
            int y=queue.peek()[1];
            queue.poll();
            if(x==r-1 && y==c-1)
                return true;
            for(int []d: dir) {
                int nx=x+d[0],ny=y+d[1];
                if(nx>=0 && nx<r && ny>=0 && ny<c && !visited[nx][ny]) {
                    if(Math.abs(h[x][y]-h[nx][ny])<=limit) {
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny]=true;
                    }
                }
            }  
        }
        return false;
    }
}
