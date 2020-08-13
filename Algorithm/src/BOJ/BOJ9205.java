// https://www.acmicpc.net/problem/9205
// 20.8.13. ventania1680
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ9205 {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<int[]> s = new Stack<>();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[][] loc = new int[n + 2][2];
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                loc[i][0] = Integer.parseInt(st.nextToken());
                loc[i][1] = Integer.parseInt(st.nextToken());
            }

            if (Math.abs(loc[0][0] - loc[n + 1][0]) + Math.abs(loc[0][1] - loc[n + 1][1]) <= 1000) {
                sb.append("happy\n");
                continue;
            } else {
                boolean[] visited = new boolean[n + 2];
                Arrays.fill(visited, false);
                s.clear();
                s.push(new int[] {0, loc[0][0], loc[0][1]});
                int[] tmp = new int[3];
                while(!s.empty()) {
                    tmp = s.pop();
                    if (tmp[0] == n + 1)
                        break;
                    if (visited[tmp[0]])
                        continue;
                    visited[tmp[0]] = true;
                    for (int i = 1; i <= n + 1; i++) {
                        if (visited[i])
                            continue;
                        if (Math.abs(tmp[1] - loc[i][0]) + Math.abs(tmp[2] - loc[i][1]) <= 1000)
                            s.push(new int[] {i, loc[i][0], loc[i][1]});
                    }
                }
                if (tmp[0] == n + 1)
                    sb.append("happy\n");
                else
                    sb.append("sad\n");
            }
        }
        System.out.print(sb.toString());
    }
}
