// https://www.acmicpc.net/problem/10282
// 20.11.11. ventania1680
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class dep implements Comparable<dep> {
    int comp;
    int time;

    public dep(int comp, int time) {
        this.comp = comp;
        this.time = time;
    }

    public int compareTo(dep o) {
        return Integer.compare(this.time, o.time);
    }
}

public class BOJ10282 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ArrayList<dep>[] al = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++)
                al[i] = new ArrayList<>();

            while(d-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                al[b].add(new dep(a, s));
            }

            int[] infected = new int[n + 1];
            Arrays.fill(infected, Integer.MAX_VALUE);
            infected[c] = 0;
            PriorityQueue<dep> pq = new PriorityQueue<>();
            pq.offer(new dep(c, 0));
            while(!pq.isEmpty()) {
                dep cur = pq.poll();
                for (dep i : al[cur.comp]) {
                    int newTime = cur.time + i.time;
                    if (infected[i.comp] > newTime) {
                        infected[i.comp] = newTime;
                        pq.offer(new dep(i.comp, newTime));
                    }
                }
            }

            int cnt = 0;
            int max = 0;
            for (int i : infected) {
                if (i == Integer.MAX_VALUE) continue;
                cnt++;
                max = Math.max(max, i);
            }
            sb.append(cnt).append(' ').append(max).append('\n');
        }
        System.out.print(sb);
    }
}
