class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int pos=-1,min=Integer.MAX_VALUE;
        for(int i=0;i<points.length;i++) {
            if(x==points[i][0] || y==points[i][1]) {
            int dist=Math.abs(points[i][0]-x)+Math.abs(points[i][1]-y);
            if(dist<min) {
                min=dist;
                pos=i;
            }
            }
        }
        return pos;
    }
}