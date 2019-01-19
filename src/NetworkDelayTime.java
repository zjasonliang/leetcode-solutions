import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        Set<Integer> visited = new HashSet<>();

        int[] dist = new int[N + 1];

        for (int i = 1; i <= N; i++)
            dist[i] = Integer.MAX_VALUE;

        dist[K] = 0;

        Map<Integer, Integer>[] adj = new Map[N + 1];

        for (int[] time : times) {
            if (adj[time[0]] == null)
                adj[time[0]] = new HashMap<>();

            adj[time[0]].put(time[1], time[2]);
        }

        pq.add(new int[] {K, 0});

        int current = -1;

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (temp[1] > dist[temp[0]])
                continue;

            current = temp[0];
            visited.add(current);
            if (adj[current] != null)
                for (int node : adj[current].keySet()) {
                    if (!visited.contains(node)) {
                        if (dist[current] + adj[current].get(node) < dist[node]) {
                            dist[node] = dist[current] + adj[current].get(node);
                            pq.add(new int[] {node, dist[node]});
                        }
                    }
                }
        }

        if (visited.size() == N)
            return dist[current];
        else
            return -1;
    }

    public static void main(String[] args) {
        int N = 3;
        int K = 1;
        int[][] times = {
                {1,2,1},{2,3,2},{1,3,2}
        };

        NetworkDelayTime s = new NetworkDelayTime();
        System.out.println(s.networkDelayTime(times, N, K));
    }
}
