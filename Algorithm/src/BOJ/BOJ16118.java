// https://www.acmicpc.net/problem/16118
// 20.11.11. ventania1680
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class stump implements Comparable<stump> {
    int pos;
    int dist;
    boolean run;
    
    public stump(int pos, int dist) {
        this.pos = pos;
        this.dist = dist;
        this.run = true;
    }

    public stump(int pos, int dist, boolean run) {
        this.pos = pos;
        this.dist = dist;
        this.run = run;
    }

    public int compareTo(stump o) {
        return Integer.compare(this.dist, o.dist);
    }
}

public class BOJ16118 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<stump>[] al = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            al[i] = new ArrayList<>();

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())*2;
            al[a].add(new stump(b, d));
            al[b].add(new stump(a, d));
        }

        int[] fox = new int[n+1];
        int[][] wolf = new int[2][n+1];
        Arrays.fill(fox, Integer.MAX_VALUE);
        Arrays.fill(wolf[0], Integer.MAX_VALUE);
        Arrays.fill(wolf[1], Integer.MAX_VALUE);
        fox[1] = 0;
        wolf[0][1] = 0;

        PriorityQueue<stump> fpq = new PriorityQueue<>();
        fpq.offer(new stump(1, 0));
        while(!fpq.isEmpty()) {
            stump cur = fpq.poll();
            for (stump i : al[cur.pos]) {
                int newDist = cur.dist+i.dist;
                if (fox[i.pos] > newDist) {
                    fox[i.pos] = newDist;
                    fpq.offer(new stump(i.pos, newDist));
                }
            }
        }
        PriorityQueue<stump> wpq = new PriorityQueue<>();
        wpq.offer(new stump(1, 0));
        while(!wpq.isEmpty()) {
            stump cur = wpq.poll();
            for (stump i : al[cur.pos]) {
                int newDist = cur.dist;
                if (cur.run) {
                    newDist += i.dist / 2;
                    if (wolf[1][i.pos] > newDist) {
                        wolf[1][i.pos] = newDist;
                        wpq.offer(new stump(i.pos, newDist, false));
                    }
                } else {
                    newDist += i.dist * 2;
                    if (wolf[0][i.pos] > newDist) {
                        wolf[0][i.pos] = newDist;
                        wpq.offer(new stump(i.pos, newDist, true));
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (fox[i] < Math.min(wolf[0][i], wolf[1][i]))
                answer++;
        }
        System.out.println(answer);
    }
}
