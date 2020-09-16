// https://www.acmicpc.net/problem/1167
// 20.9.16. ventania1680
package BOJ;

import java.util.*;
import java.io.*;

public class BOJ1167 {
    static ArrayList<Integer>[] path = new ArrayList[100001];
    static ArrayList<Integer>[] dist = new ArrayList[100001];
    static boolean[] visited = new boolean[100001];
    static long diameter = 0;
    static int tmp;
    static void dfs(int idx, long curLen) {
        if (curLen > diameter) {
            diameter = curLen;
            tmp = idx;
        }
        visited[idx] = true;
        for (int i = 0; i < path[idx].size(); i++) {
            if (!visited[path[idx].get(i)])
                dfs(path[idx].get(i), curLen+dist[idx].get(i));
        }
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());

        for (int i = 1; i <= v; i++) {
            path[i] = new ArrayList<>();
            dist[i] = new ArrayList<>();
        }

        for (int i = 1; i <= v; i++) {
            String[] str = br.readLine().split(" ");
            int j = 1;
            while(str[j].compareTo("-1") != 0) {
                path[Integer.parseInt(str[0])].add(Integer.parseInt(str[j++]));
                dist[Integer.parseInt(str[0])].add(Integer.parseInt(str[j++]));
            }
        }


        dfs(1, 0);
        Arrays.fill(visited, false);
        dfs(tmp, 0);
        System.out.println(diameter);
    }
}
