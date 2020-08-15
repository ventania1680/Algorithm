// https://www.acmicpc.net/problem/11403
// 20.8.15. ventania1680
package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11403 {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<LinkedList<Integer>> ll = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ll.add(new LinkedList<>());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    ll.get(i).add(j);
                }
            }
        }
        boolean[][] answer = new boolean[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(answer[i], false);
        boolean[] visited = new boolean[n];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (answer[i][j])
                    visited[j] = true;
                else
                    visited[j] = false;
            }
            for (int j : ll.get(i)) {
                st.add(j);
                visited[j] = answer[i][j] = true;
            }
            while(!st.isEmpty()) {
                int cur = st.pop();
                for (int j : ll.get(cur)) {
                    if (!visited[j]) {
                        st.add(j);
                        visited[j] = answer[i][j] = answer[cur][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (boolean[] i : answer) {
            for (boolean j : i) {
                if (j)
                    sb.append("1 ");
                else
                    sb.append("0 ");
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
