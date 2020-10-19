// https://programmers.co.kr/learn/courses/30/lessons/42898
// 20.10.19. ventania1680

package Programmers;

public class P42898 {
    public static int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] dp = new int[n+1][m+1];
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        dp[1][1] = 1;
        for (int i = 2; i < n+1; i++) {
            if (dp[i][1] == -1) break;
            dp[i][1] = 1;
        }
        for (int i = 2; i < m+1; i++) {
            if (dp[1][i] == -1) break;
            dp[1][i] = 1;
        }

        for (int i = 2; i < n+1; i++) {
            for (int j = 2; j < m+1; j++) {
                if (dp[i][j] == -1) continue;
                if (dp[i-1][j] == -1 && dp[i][j-1] == -1) dp[i][j] = 0;
                else if (dp[i-1][j] == -1) dp[i][j] = dp[i][j-1];
                else if (dp[i][j-1] == -1) dp[i][j] = dp[i-1][j];
                else dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
            }
        }

        return dp[n][m] % mod;
    }
}
