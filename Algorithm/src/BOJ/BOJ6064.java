// acmicpc.net/problem/6064
// 20.8.11. ventania1680
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6064 {
    public static int findGCD(int m, int n) {
        while (n > 0) {
            int r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int gcd = m * n / (m > n ? findGCD(m, n) : findGCD(n, m));
            int tx = x, ty = x % n;
            if (ty == 0) ty = n;
            int answer = x;
            while (ty != y && answer <= x + gcd) {
                ty += (m - n);
                if (m > n) {
                    ty %= n;
                }
                else {
                    ty = Math.floorMod(ty, n);
                }
                if (ty == 0) ty = n;
                answer += m;
            }
            if (ty != y)
                answer = -1;
            sb.append(answer + "\n");
        }
        System.out.print(sb);
    }
}
