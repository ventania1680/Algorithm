// https://www.acmicpc.net/problem/1753
// 20.11.11. ventania1680
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class path implements Comparable<path> {
    int pos;
    int dist;

    public path(int pos, int dist) {
        this.pos = pos;
        this.dist = dist;
    }

    public int compareTo(path o) {
        return Integer.compare(this.dist, o.dist);
    }
}

public class BOJ1753 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());


        ArrayList<path>[] al = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            al[i] = new ArrayList<>();
        }

        while(E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            path p = new path(v, w);
            al[u].add(p);
        }

        int[] dist = new int[V+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[K] = 0;

        PriorityQueue<path> pq = new PriorityQueue<>();
        pq.offer(new path(K, 0));
        while(!pq.isEmpty()) {
            path cur = pq.poll();
            for (path p : al[cur.pos]) {
                int newDist = p.dist + cur.dist;
                if (dist[p.pos] > newDist) {
                    dist[p.pos] = newDist;
                    pq.offer(new path(p.pos, newDist));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append('\n');
            }
        }
        System.out.print(sb);
    }
}
