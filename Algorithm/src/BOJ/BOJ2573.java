// https://www.acmicpc.net/problem/2573
// 20.9.14. ventania1680
package BOJ;

import java.util.*;
import java.io.*;

public class BOJ2573 {
    static int[][] iceberg = new int[300][300];
    static int min_row, max_row, min_col, max_col;
    static int n, m;
    static Stack<int[]> stack = new Stack<>();
    static boolean[][] visited = new boolean[300][300];

    public static void dfs(int x, int y) {
        if (visited[y][x]) {
            return;
        }
        visited[y][x] = true;
        int zero = 4;
        if (iceberg[y-1][x] != 0) {
            dfs(x, y-1);
            zero--;
        }
        if (iceberg[y+1][x] != 0) {
            dfs(x, y+1);
            zero--;
        }
        if (iceberg[y][x-1] != 0) {
            dfs(x-1, y);
            zero--;
        }
        if (iceberg[y][x+1] != 0) {
            dfs(x+1, y);
            zero--;
        }
        stack.push(new int[] {x,y,iceberg[y][x]-zero});
    }

    public static void updateIceberg() {
        while(!stack.isEmpty()) {
            int x = stack.peek()[0];
            int y = stack.peek()[1];
            int val = stack.pop()[2];
            if (val < 0) val = 0;
            iceberg[y][x] = val;
            visited[y][x] = false;
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        min_row = min_col = 300;
        max_row = max_col = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp  = Integer.parseInt(st.nextToken());
                if (tmp > 0) {
                    if (min_row > i) min_row = i;
                    if (max_row < i) max_row = i;
                    if (min_col > j) min_col = j;
                    if (max_col < j) max_col = j;
                    iceberg[i][j] = tmp;
                }
            }
        }

        int year = 0;
        int cnt = 0;
        while(true) {
            cnt = 0;
            for (int i = min_row; i <= max_row; i++) {
                for (int j = min_col; j <= max_col; j++) {
                    if (iceberg[i][j] > 0 && !visited[i][j]) {
                        cnt++;
                        dfs(j, i);
                    }
                }
            }
            updateIceberg();
            if (cnt != 1) break;
            year++;
        }
        if (cnt == 0) System.out.print(0);
        else System.out.print(year);
    }
}
