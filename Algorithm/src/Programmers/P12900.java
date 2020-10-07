package Programmers;

public class P12900 {
    public int solution(int n) {
        long[] dp = new long[60001];
        int mod = 1000000007;
        dp[1] = 1; dp[2] = 2; dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%mod;
        }
        return (int) dp[n];
    }
}
