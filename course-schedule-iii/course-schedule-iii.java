class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        
        Queue<Integer> heap = new PriorityQueue < > ((a, b) -> b - a);
        int time = 0;
        for(int[] course : courses){
            if(course[0] + time <= course[1]){
                heap.offer(course[0]);
                time += course[0];
            } else if (!heap.isEmpty() && course[0] < heap.peek()){
                time += course[0] - heap.poll();
                heap.offer(course[0]);
            }
        }
        
        return heap.size();
    }
}