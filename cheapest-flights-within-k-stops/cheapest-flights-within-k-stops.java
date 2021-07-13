class Solution {
    static class Triple implements Comparable<Triple> {
        int node;
        int distance;
        int depth;

        public Triple(int node, int distance) {
            this.node = node;
            this.distance = distance;
            this.depth = 0;
        }

        public Triple(int node, int distance, int depth) {
            this.node = node;
            this.distance = distance;
            this.depth = depth;
        }

        @Override
        public int compareTo(Triple o) {
            return Integer.compare(this.distance, o.distance);
        }
    }


    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<Triple>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new Triple(flight[1], flight[2]));
        }
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        return dijkstra(graph, src, dst, K, distance);
    }

    private static int dijkstra(Map<Integer, List<Triple>> graph, int src, int dst, int K, int[] distance) {
        PriorityQueue<Triple> priorityQueue = new PriorityQueue<>();
        int[] minHops = new int[graph.size()];
        Arrays.fill(minHops, -1);
        priorityQueue.add(new Triple(src, 0, 0));
        while (!priorityQueue.isEmpty()) {
            Triple currentNode = priorityQueue.poll();
            if (currentNode.node == dst) return currentNode.distance;
            if (currentNode.depth > K) continue;
            if (minHops[currentNode.node] != -1 && minHops[currentNode.node] < currentNode.depth) continue;
            minHops[currentNode.node] = currentNode.depth;
            for (Triple child : graph.get(currentNode.node)) {
                priorityQueue.add(new Triple(child.node, child.distance + currentNode.distance, currentNode.depth + 1));
            }
        }
        return -1;
    }
}