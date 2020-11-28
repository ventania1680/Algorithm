// https://www.acmicpc.net/problem/1865
// 20.11.18. ventania1680
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1865 {
	static long[] cost = new long[501];
	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int[][] route = new int[m*2+w][3];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				route[i][0] = Integer.parseInt(st.nextToken());
				route[i][1] = Integer.parseInt(st.nextToken());
				route[i][2] = Integer.parseInt(st.nextToken());
				route[i+m+w][0] = route[i][1];
				route[i+m+w][1] = route[i][0];
				route[i+m+w][2] = route[i][2];
			}
			for (int i = m; i < m+w; i++) {
				st = new StringTokenizer(br.readLine());
				route[i][0] = Integer.parseInt(st.nextToken());
				route[i][1] = Integer.parseInt(st.nextToken());
				route[i][2] = -Integer.parseInt(st.nextToken());
			}
			
			long INF = Integer.MAX_VALUE;
			
			
			boolean updated = false;
			boolean p = false;
			for (int k = 1; k <= n; k++) {
				Arrays.fill(cost, INF);
				cost[k] = 0;
				for (int i = 0; i < n; i++) {
					updated = false;
					for (int j = 0; j < m*2+w; j++) {
						if (cost[route[j][0]] == INF) continue;
						if (cost[route[j][1]] > cost[route[j][0]] + route[j][2]) {
							updated = true;
							cost[route[j][1]] = cost[route[j][0]] + route[j][2];
						}
					}
					if (!updated) break;
				}
				if (updated) {
					System.out.println("YES");
					p = true;
					break;
				}
			}
			if (!p)
				System.out.println("NO");
		}
	}
}
