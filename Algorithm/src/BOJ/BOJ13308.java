// https://www.acmicpc.net/problem/13308
// 20.11.11. ventania1680
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class way implements Comparable<way> {
    int pos;
    long cost;
    int oil;

    public way(int pos, long cost) {
        this.pos = pos;
        this.cost = cost;
    }

    public way(int pos, long cost, int oil) {
        this.pos = pos;
        this.cost = cost;
        this.oil = oil;
    }

    public int compareTo(way o) {
        return -Long.compare(this.cost, o.cost);
    }
}

public class BOJ13308 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 기름 가격
        int[] oil = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; st.hasMoreTokens(); i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }
        // 도로 정보 입력
        ArrayList<way>[] al = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            al[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            al[a].add(new way(b, c));
            al[b].add(new way(a, c));
        }

        long[][] dp = new long[n+1][2501];
        for (int i = 1; i <= n; i++)
            Arrays.fill(dp[i], -1);
        PriorityQueue<way> pq = new PriorityQueue<>();
        pq.offer(new way(1, 0, oil[1]));
        long answer = 0;
        while(!pq.isEmpty()) {
            int pos = pq.peek().pos;
            long cost = -pq.peek().cost;
            int minO = pq.poll().oil;
            if (dp[pos][minO] != -1) continue;
            dp[pos][minO] = cost;
            if (pos == n) {
                answer = cost;
                break;
            }
            for (way i : al[pos]) {
                if (dp[i.pos][Math.min(minO, oil[i.pos])] != -1) continue;
                pq.offer(new way(i.pos, -cost-i.cost*minO, Math.min(minO, oil[i.pos])));
            }
        }
        System.out.println(answer);
    }
}