package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1194 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][][] visited = new int[64][n][m];
        char[][] maze = new char[n][m];
        for (int i = 0; i < 64; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            maze[i] = br.readLine().toCharArray();
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == '0') {
                    queue.offer(new int[] {i, j, 0, 0});
                    visited[0][i][j] = 0;
                    i = n;
                    break;
                }
            }
        }

        int answer = -1;
        int[][] pos = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (maze[cur[0]][cur[1]] == '1') {
                if (answer == -1)
                    answer = visited[cur[3]][cur[0]][cur[1]];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int y = cur[0] + pos[i][0];
                int x = cur[1] + pos[i][1];
                int cost = cur[2]+1;
                int keys = cur[3];
                if (y >= n || y < 0 || x >= m || x < 0)
                    continue;
                if (visited[keys][y][x] <= cost)
                    continue;
                if (maze[y][x] == '#')
                    continue;
                if (maze[y][x] >= 'A' && maze[y][x] <= 'F') {
                    if ((keys&(1<<maze[y][x]-'A'))==0)
                        continue;
                }
                if (maze[y][x] >= 'a' && maze[y][x] <= 'f') {
                    keys |= (1<<maze[y][x]-'a');
                }

                visited[keys][y][x] = cost;
                queue.offer(new int[] {y, x, cost, keys});
            }
        }
        System.out.println(answer);
    }
}