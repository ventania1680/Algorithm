// https://www.acmicpc.net/problem/1967
// 20.11.28. ventania1680
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1967 {
    static ArrayList<int[]>[] al = new ArrayList[10001];
    static boolean[] visited = new boolean[10001];
    static int idx = 0, max = 0;

    static void dfs(int pos, int cost) {
        if (!visited[pos]) {
            visited[pos] = true;
            if (cost > max) {
                idx = pos;
                max = cost;
            }
            for (int[] arr : al[pos]) {
                if (visited[arr[0]]) continue;
                dfs(arr[0], cost + arr[1]);
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++)
            al[i] = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            al[a].add(new int[] {b, c});
            al[b].add(new int[] {a, c});
        }

        dfs(1, 0);
        Arrays.fill(visited, false);
        max = 0;
        dfs(idx, 0);
        System.out.println(max);
    }
}
