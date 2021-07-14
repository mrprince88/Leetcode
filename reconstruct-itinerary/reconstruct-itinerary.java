class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> map=new HashMap<>();
        List<String> route=new ArrayList<>();
        
        for(List<String> i: tickets)
            map.computeIfAbsent(i.get(0),k->new PriorityQueue<>()).add(i.get(1));
        
        Stack<String> stack=new Stack<>();
        stack.add("JFK");
        
        while(!stack.isEmpty()) {
            while(map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty())
                stack.push(map.get(stack.peek()).poll());
            route.add(0,stack.pop());
        }
        return route;
    }
}