// https://www.acmicpc.net/problem/2206
// 20.11.30. ventania1680
package BOJ2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] map = new int[1000][1000];
    static boolean[][][] visited = new boolean[2][1000][1000];
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] str1 = str.split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < m; j++)
                map[i][j] = str.charAt(j) - '0';
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 0, 1});
        visited[0][0][0] = true;
        visited[1][0][0] = true;
        int answer = -1;
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            if (arr[0] == n-1 && arr[1] == m-1) {
                answer = arr[3];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int row = arr[0] + dir[i][0];
                int col = arr[1] + dir[i][1];
                if (row < 0 || row >= n || col < 0 || col >= m) continue;
                if (map[row][col] == 0) {
                    if (!visited[arr[2]][row][col]) {
                        visited[arr[2]][row][col] = true;
                        queue.offer(new int[]{row, col, arr[2], arr[3] + 1});
                    }
                } else {
                    if (arr[2] == 1) continue;
                    if (!visited[1][row][col]) {
                        visited[1][row][col] = true;
                        queue.offer(new int[]{row, col, 1, arr[3] + 1});
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
