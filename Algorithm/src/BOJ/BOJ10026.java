// https://www.acmicpc.net/problem/10026
// 20.8.14. ventania1680
// BFS
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026 {
    static boolean[][] visited;
    static Queue<Integer> q;
    static char[][] img;
    static int n;
    final static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    static void BFS(int i, int j) {
        q.offer(i * 1000 + j);
        visited[i][j] = true;
        while(!q.isEmpty()) {
            int y = q.poll();
            int x = y % 1000;
            y /= 1000;
            // 상하좌우
            for (int k = 0; k < 4; k++) {
                y += dir[k][0];
                x += dir[k][1];
                // 유효한 좌표인지 검사
                if (y >= 0 && y < n && x >= 0 && x < n) {
                    // 방문한 적 없고 같은 색일 경우
                    if (!visited[y][x] && img[i][j] == img[y][x]) {
                        q.offer(y * 1000 + x);
                        visited[y][x] = true;
                    }
                }
                y -= dir[k][0];
                x -= dir[k][1];
            }
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        img = new char[n][n];
        for (int i = 0; i < n; i++)
            img[i] = br.readLine().toCharArray();

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(visited[i], false);
        q = new LinkedList<>();
        int zone1 = 0, zone2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 방문한 적 없는 좌표의 경우 BFS로 탐색
                if (!visited[i][j]) {
                    zone1++;
                    BFS(i, j);
                }
            }
        }
        // 적록색약
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img[i][j] == 'G')
                    img[i][j] = 'R';
            }
            // visited 배열 초기화
            Arrays.fill(visited[i], false);
        }
        // 큐 초기화
        q.clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    zone2++;
                    BFS(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(zone1 + " " + zone2);
        System.out.print(sb);
    }
}
