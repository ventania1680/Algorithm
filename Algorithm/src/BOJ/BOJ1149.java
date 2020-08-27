// https://www.acmicpc.net/problem/1149
// 20.8.27. ventania1680
package BOJ;

import java.util.*;
import java.io.*;

public class BOJ1149 {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][3];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + Integer.parseInt(st.nextToken());
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + Integer.parseInt(st.nextToken());
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + Integer.parseInt(st.nextToken());
        }
        System.out.print(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}
