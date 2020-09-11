// https://www.acmicpc.net/problem/1058
// 20.9.11. ventania1680
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ1058 {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] friend = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'Y') {
                    friend[i][j] = true;
                }
            }
        }

        ArrayList<Integer>list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            list.clear();
            visited[i] = true;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (friend[i][j]) {
                    list.add(j);
                    cnt++;
                    visited[j] = true;
                }
            }
            for (int j : list) {
                for (int k = 0; k < n; k++) {
                    if (friend[j][k] && !visited[k]) {
                        cnt++;
                        visited[k] = true;
                    }
                }
            }
            if (max < cnt)
                max = cnt;
        }
        System.out.print(max);
    }
}
