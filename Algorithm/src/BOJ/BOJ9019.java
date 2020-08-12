// https://www.acmicpc.net/problem/9019
// 20.8.12. ventania1680
// BFS

package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9019 {
    static boolean[] visited = new boolean[10001];
    static String[] path = new String[10001];

    static int f(int num, char c) {
        switch (c) {
            case 'D':
                return (num * 2) % 10000;
            case 'S':
                return (num == 0) ? 9999 : --num;
            case 'L':
                return (num % 1000) * 10 + num / 1000;
            case 'R':
                return num / 10 + num % 10 * 1000;
        }
        return 0;
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Arrays.fill(path, "");
            Arrays.fill(visited, false);
            q.clear();

            q.add(a);
            visited[a] = true;
            int parent = 0, cur = 0;
            while (!q.isEmpty() && q.peek() != b) {
                parent = q.peek();
                cur = f(parent, 'D');
                if (!visited[cur]) {
                    q.offer(cur);
                    visited[cur] = true;
                    path[cur] = path[parent] + "D";
                    q.add(cur);
                }

                cur = f(parent, 'S');
                if (!visited[cur]) {
                    visited[cur] = true;
                    path[cur] = path[parent] + "S";
                    q.add(cur);
                }

                cur = f(parent, 'L');
                if (!visited[cur]) {
                    visited[cur] = true;
                    path[cur] = path[parent] + "L";
                    q.add(cur);
                }

                cur = f(parent, 'R');
                if (!visited[cur]) {
                    visited[cur] = true;
                    path[cur] = path[parent] + "R";
                    q.add(cur);
                }
                q.poll();
            }
            sb.append(path[q.peek()] + "\n");
        }
        System.out.print(sb.toString());
    }
}
