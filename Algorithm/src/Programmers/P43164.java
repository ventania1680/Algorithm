// https://programmers.co.kr/learn/courses/30/lessons/43164
// 20.10.23. ventania1680
package Programmers;

import java.util.ArrayList;
import java.util.Comparator;

public class P43164 {
    static String[][] t;
    static boolean[] visited;
    static ArrayList<String[]> paths = new ArrayList<>();

    static void dfs(String str, int n, int k, String[] path) {
        if (n == k-1) {
            paths.add(path.clone());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && t[i][0].equals(str)) {
                path[k] = t[i][1];
                visited[i] = true;
                dfs(t[i][1], n, k+1, path);
                visited[i] = false;
            }
        }
    }

    public static String[] solution(String[][] tickets) {
        int n = tickets.length;
        t = tickets.clone();
        visited = new boolean[n];

        String[] path = new String[n + 1];
        for (int i = 0; i < n; i++) {
            if (tickets[i][0].equals("ICN")) {
                path[0] = "ICN";
                path[1] = tickets[i][1];
                visited[i] = true;
                dfs(tickets[i][1], n, 2, path);
                visited[i] = false;
            }
        }

        Comparator<String[]> comp = (o1, o2) -> {
            for (int i = 0; i < o1.length; i++) {
                if (o1[i].compareTo(o2[i]) == 0)
                    continue;
                return o1[i].compareTo(o2[i]);
            }
            return 0;
        };

        paths.sort(comp);
        return paths.get(0);
    }
}
