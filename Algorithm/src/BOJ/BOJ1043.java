// https://www.acmicpc.net/problem/1043
// 20.8.28. ventania1680

package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1043 {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        if (l > 0) {
            boolean[] visitedParty = new boolean[m];
            boolean[] visitedPerson = new boolean[n + 1];
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < l; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                q.offer(tmp);
                visitedPerson[tmp] = true;
            }

            int[][] party = new int[m][];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                l = Integer.parseInt(st.nextToken());
                party[i] = new int[l];
                for (int j = 0; j < l; j++) {
                    party[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            while(!q.isEmpty()) {
                for (int i = 0; i < m; i++) {
                    if (visitedParty[i])
                        continue;
                    for (int j = 0; j < party[i].length; j++) {
                        if (q.peek() == party[i][j]) {
                            for (int k = 0; k < party[i].length; k++) {
                                if (!visitedPerson[party[i][k]]) {
                                    q.offer(party[i][k]);
                                    visitedPerson[party[i][k]] = true;
                                }
                            }
                            visitedParty[i] = true;
                            cnt++;
                        }
                    }
                }
                q.poll();
            }
        }
        System.out.print(m - cnt);
    }
}
