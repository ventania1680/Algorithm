package BOJ;

import java.util.*;
import java.io.*;

class edge implements Comparable<edge>{
    int node;
    int cost;

    public edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(edge o) {
        if (this.cost > o.cost)
            return 1;
        else if (this.cost < o.cost)
            return -1;
        return 0;
    }
}

public class BOJ1504 {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<edge>[] al = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            al[i] = new ArrayList<edge>();
        }
        int v1, v2, cost;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            al[v1].add(new edge(v2, cost));
            al[v2].add(new edge(v1, cost));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int[] d1 = new int[n+1];
        int[] d2 = new int[n+1];
        int[] d3 = new int[n+1];
        boolean[] visited = new boolean[n+1];
        PriorityQueue<edge> pq = new PriorityQueue<>();

        pq.add(new edge(1, 0));
        while(!pq.isEmpty()) {
            edge cur = pq.poll();
            if (visited[cur.node]) continue;
            visited[cur.node] = true;
            d1[cur.node] = cur.cost;
            for (edge next : al[cur.node]) {
                pq.add(new edge(next.node, cur.cost+next.cost));
            }
        }

        Arrays.fill(visited, false);
        pq.add(new edge(v1, 0));
        while(!pq.isEmpty()) {
            edge cur = pq.poll();
            if (visited[cur.node]) continue;
            visited[cur.node] = true;
            d2[cur.node] = cur.cost;
            for (edge next : al[cur.node]) {
                pq.add(new edge(next.node, cur.cost+next.cost));
            }
        }

        Arrays.fill(visited, false);
        pq.add(new edge(v2, 0));
        while(!pq.isEmpty()) {
            edge cur = pq.poll();
            if (visited[cur.node]) continue;
            visited[cur.node] = true;
            d3[cur.node] = cur.cost;
            for (edge next : al[cur.node]) {
                pq.add(new edge(next.node, cur.cost+next.cost));
            }
        }

        int a = d1[v1]+d2[v2]+d3[n];
        int b = d1[v2]+d3[v1]+d2[n];
        int ans = -1;
        if (a != 0 && b != 0) {
            ans = Math.min(a, b);
        } else if (a == 0 && b != 0) {
            ans = b;
        } else if (b == 0 && a != 0) {
            ans = a;
        }
        System.out.println(ans);
    }
}
