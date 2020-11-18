// https://www.acmicpc.net/problem/1738
// 20.11.18. ventania1680
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1738 {
	static int[][] arr = new int[20000][3];
	static long[] cost = new long[101];
	static int[] p = new int[101];
	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int NINF = Integer.MIN_VALUE;
		Arrays.fill(cost, NINF);
		Arrays.fill(p, -1);
		cost[n] = 0;
		p[n] = n;
		
		boolean updated = false;
		for (int i = 0; i < n; i++) {
			updated = false;
			for (int j = 0; j < m; j++) {
				if (cost[arr[j][0]] == NINF) continue;
				if (cost[arr[j][1]] < cost[arr[j][0]] + arr[j][2]) {
					updated = true;
					cost[arr[j][1]] = cost[arr[j][0]] + arr[j][2];
					p[arr[j][1]] = arr[j][0];
				}
			}
			if (!updated) break;
		}
		
		if (updated || cost[1] == NINF)
			System.out.println(-1);
		else {
			StringBuilder sb = new StringBuilder();
			int idx = 1;
			while(idx != n) {
				sb.append(idx).append(' ');
				idx = p[idx];
			}
			sb.append(n);
			System.out.println(sb);
		}
	}
}
