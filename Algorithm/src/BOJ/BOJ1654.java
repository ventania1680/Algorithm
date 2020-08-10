// https://www.acmicpc.net/problem/1654
// 20.8.10. ventania1680
// 이분탐색 변형으로 풀이 가능
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[k];
        long sum = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        long high = sum / n;
        long low = 1;
        long half = (high + low) / 2;
        int cnt;
        long answer = 0;
        while(high >= low) {
            cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += arr[i] / half;
            }
            if (cnt >= n) {
                if (answer < half) answer = half;
                low = half + 1;
                half = (high + low) / 2;
            }
            else if (cnt < n) {
                high = half - 1;
                half = (high + low) / 2;
            }
        }
        System.out.println(answer);
    }
}
