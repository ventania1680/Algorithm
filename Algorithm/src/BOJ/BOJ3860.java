// https://www.acmicpc.net/problem/3860
// 20.11.18. ventania1680
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3860 {
	static int[][] pos = {{0, 1},{1, 0}, {0, -1}, {-1, 0}};
	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0) break;
			
			int g = Integer.parseInt(br.readLine());
			boolean[][] grave = new boolean[w][h];
			for (int i = 0; i < g; i++) {
				st = new StringTokenizer(br.readLine());
				grave[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}
			
			ArrayList<int[]> list = new ArrayList<>();
			
			int e = Integer.parseInt(br.readLine());
			boolean[][] portal = new boolean[w][h];
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int[] ghost = new int[5];
				ghost[0] = Integer.parseInt(st.nextToken());
				ghost[1] = Integer.parseInt(st.nextToken());
				ghost[2] = Integer.parseInt(st.nextToken());
				ghost[3] = Integer.parseInt(st.nextToken());
				ghost[4] = Integer.parseInt(st.nextToken());
				portal[ghost[0]][ghost[1]] = true;
				list.add(ghost);
			}
			
			for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					if (grave[x][y] || portal[x][y]) continue;
					if (x == w-1 && y == h-1) break;
					for (int j = 0; j < 4; j++) {
						int newx = x+pos[j][0];
						int newy = y+pos[j][1];
						if (newx < 0 || newx >= w || newy < 0 || newy >= h || grave[newx][newy]) continue;
						list.add(new int[] {x, y, newx, newy, 1});
					}
				}
			}
			
			
			long[][] cost = new long[w][h];
			int INF = Integer.MAX_VALUE;
			for (int i = 0; i < w; i++)
				Arrays.fill(cost[i], INF);
			cost[0][0] = 0;
			
			boolean updated = false;
			for (int i = 0; i < w*h; i++) {
				updated = false;
				for (int j = 0; j < list.size(); j++) {
					if (cost[list.get(j)[0]][list.get(j)[1]] == INF) continue;
					if (cost[list.get(j)[2]][list.get(j)[3]] > cost[list.get(j)[0]][list.get(j)[1]] + list.get(j)[4]) {
						updated = true;
						cost[list.get(j)[2]][list.get(j)[3]] = cost[list.get(j)[0]][list.get(j)[1]] + list.get(j)[4];
					}
				}
				if (!updated) break;
			}
			
			if (updated)
				System.out.println("Never");
			else if (cost[w-1][h-1] == INF)
				System.out.println("Impossible");
			else
				System.out.println(cost[w-1][h-1]);
		}
	}
}
