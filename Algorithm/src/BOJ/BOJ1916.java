// https://www.acmicpc.net/problem/1916
// 20.11.28. ventania1680
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class bus implements Comparable<bus> {
    int dest;
    int cost;

    public bus (int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }

    public int compareTo(bus o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class BOJ1916 {
    static ArrayList<bus>[] al = new ArrayList[1001];
    static PriorityQueue<bus> pq = new PriorityQueue<>();
    static long[] minCost = new long[1001];
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++)
            al[i] = new ArrayList<>();

        int from, to, cost;
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            al[from].add(new bus(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        pq.offer(new bus(start, 0));
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[start] = 0;
        while(!pq.isEmpty()) {
            int curPos = pq.peek().dest;
            int curCost = pq.poll().cost;
            if (curPos == end) break;
            if (curCost > minCost[curPos]) continue;
            for (bus b : al[curPos]) {
                if (minCost[b.dest] > curCost + b.cost) {
                    pq.offer(new bus(b.dest, curCost + b.cost));
                    minCost[b.dest] = curCost + b.cost;
                }
            }
        }
        System.out.println(minCost[end]);
    }
}
