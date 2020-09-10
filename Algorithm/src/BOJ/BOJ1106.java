// https://www.acmicpc.net/problem/1106
// 20.9.10. ventania1680

package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1106 {
    public static void solution() throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] cost = new int[n];
        int[] people = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1500];
        Arrays.fill(dp, 100000);
        dp[0] = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < n; j++) {
                int pos = i + people[j];
                dp[pos] = Math.min(dp[pos], dp[i] + cost[j]);
                if (pos >= c)
                    list.add(dp[pos]);
            }
        }

        int min = 100000;
        for (int i : list) {
            if (i < min)
                min = i;
        }

        System.out.print(min);
    }
}
